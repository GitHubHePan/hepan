package org.hepan.service.impl;

import org.hepan.VO.RegionVO;
import org.hepan.service.HepanRegionService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class RegionServiceImplTest {

    @Autowired
    HepanRegionService regionService;

    @Test
    void getRegions() {
        List<RegionVO> regions = regionService.getRegions();
        System.out.println(regions);
        Assert.assertNotEquals(0, regions.size());
    }
}