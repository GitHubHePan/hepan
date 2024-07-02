package org.hepan.mapper;

import org.hepan.dataobject.HepanShipper;
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
class HepanShipperServiceMapperTest {

    @Autowired
    private HepanShipperMapper mapper;

    @Test
    void selectAll() {
        List<HepanShipper> list = mapper.selectAll();
        Assert.assertNotEquals(0, list.size());
    }
}