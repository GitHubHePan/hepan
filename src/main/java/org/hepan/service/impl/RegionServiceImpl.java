package org.hepan.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.hepan.VO.RegionVO;
import org.hepan.dataobject.HepanRegion;
import org.hepan.mapper.HepanRegionMapper;
import org.hepan.service.HepanRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RegionServiceImpl implements HepanRegionService {
    @Autowired
    HepanRegionMapper regionMapper;

    private List<RegionVO> getRegionData(List<HepanRegion> regionList ){
        List<RegionVO> listRegion = new ArrayList<RegionVO>();
        regionList.forEach(item -> {
            RegionVO vo = new RegionVO();
            vo.setValue(item.getId());
            vo.setLabel(item.getName());

            if(item.getChildren().size()>0){
                List<RegionVO> listCity = new ArrayList<RegionVO>();
                vo.setChildren(this.getRegionData(item.getChildren()));
            }
            listRegion.add(vo);
        });
        return listRegion;
    }

    @Override
    @Cacheable(key = "1234", cacheNames="Regions")
    public List<RegionVO> getRegions(){
        List<HepanRegion> pro = regionMapper.selectAll(1);
        return this.getRegionData(pro);
    }

}
