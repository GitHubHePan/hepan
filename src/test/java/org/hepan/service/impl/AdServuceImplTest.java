package org.hepan.service.impl;

import com.github.pagehelper.PageInfo;
import org.hepan.VO.AdVO;
import org.hepan.dataobject.HepanAd;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdServuceImplTest {

    @Autowired
    private AdServuceImpl adServuceImpl;

    @Test
    public void findeAll() {
        PageInfo<AdVO> ads = adServuceImpl.findeAll(1,10);
        Assert.assertNotEquals(0, ads.getTotal());
    }

    @Test
    public void updateAdStatus(){
        Boolean flag = adServuceImpl.updateAdStatus(28, true);
        Assert.assertTrue(flag);
    }

    @Test
    public void findById(){
        HepanAd ad = adServuceImpl.findById(28);
        Assert.assertNotNull(ad);
    }
}