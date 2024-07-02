package org.hepan.mapper;

import lombok.extern.slf4j.Slf4j;
import org.hepan.dataobject.HepanRegion;
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
@Slf4j
class HepanRegionMapperTest {

    @Autowired
    HepanRegionMapper hepanRegionMapper;

    @Test
    void selectAll() {
        List<HepanRegion> hepanRegions = hepanRegionMapper.selectAll(1);
        log.info(hepanRegions.toString());
        Assert.assertNotEquals(0, hepanRegions.size());
    }
}