package org.hepan.service;

import org.hepan.VO.RegionVO;
import org.hepan.dataobject.HepanRegion;

import java.util.List;

public interface HepanRegionService {
    List<RegionVO> getRegions();
}
