package org.hepan.mapper;

import org.hepan.dataobject.HepanAd;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdMapperTest {

    @Autowired
    private AdMapper adMapper;

    @Test
    public void findAdByAll() {
        List<HepanAd> hepanAd = adMapper.findAdAll();
        System.out.println(hepanAd);
        Assert.assertNotEquals(0, hepanAd.size() );
    }

    @Test
    public void findAdById() {
        HepanAd hepanAd = adMapper.findAdById(28);
        System.out.println(hepanAd);
        Assert.assertNotNull(hepanAd);
    }



    @Test
    @Transactional
    public void updateById(){
        HepanAd hepanAd = adMapper.findAdById(28);
        hepanAd.setEnabled(0);
        Boolean flag = adMapper.updateAd(hepanAd);
        Assert.assertTrue(flag);
    }
}