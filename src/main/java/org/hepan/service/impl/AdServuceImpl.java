package org.hepan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.hepan.VO.AdVO;
import org.hepan.dataobject.HepanAd;
import org.hepan.enums.ResEnums;
import org.hepan.exception.SysException;
import org.hepan.form.AdForm;
import org.hepan.mapper.AdMapper;
import org.hepan.service.AdService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AdServuceImpl implements AdService {

    @Autowired
    private AdMapper adMapper;


    @Override
    public PageInfo<AdVO> findeAll(Integer page, Integer size) {
        List<HepanAd> ads = adMapper.findAdAll();
        List<AdVO> adVOS = new ArrayList<>();
        for (HepanAd ad : ads) {
            AdVO adVO = new AdVO();
            BeanUtils.copyProperties(ad, adVO);
            adVO.setEnabled(ad.getEnabled() == 1);
            adVOS.add(adVO);
        }
        PageHelper.startPage(page, size);

        return new PageInfo<>(adVOS);
    }


    @Override
    public Boolean updateAdStatus(Integer id, Boolean status){
        HepanAd ad = adMapper.findAdById(id);
        if(ad == null) {
            log.error(ResEnums.AD_NOT_FOUND.getDescription());
            throw new SysException(ResEnums.AD_NOT_FOUND);
        }
        ad.setEnabled(status == true ? 1 : 0);
        return adMapper.updateAd(ad);
    }

    @Override
    public AdVO findById(Integer id) {
        HepanAd ad = adMapper.findAdById(id);
        if(ad == null) {
            log.error(ResEnums.AD_NOT_FOUND.getDescription());
            throw new SysException(ResEnums.AD_NOT_FOUND);
        }
        AdVO adVO = new AdVO();
        BeanUtils.copyProperties(ad, adVO);
        adVO.setEnabled(ad.getEnabled() == 1);
        return adVO;
    }

    @Override
    public Boolean updateAdById(AdForm ad){
        System.out.println(ad);
        HepanAd _ad = new HepanAd();
        BeanUtils.copyProperties(ad, _ad);
        _ad.setEnabled(ad.getEnabled() ? 1 : 0);
        System.out.println(_ad);
        return adMapper.updateAdById(_ad);
    }
}
