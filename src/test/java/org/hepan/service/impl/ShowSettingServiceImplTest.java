package org.hepan.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.hepan.dataobject.HepanShowSetting;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ShowSettingServiceImplTest {

    @Autowired
    ShowSettingServiceImpl service;

    @Test
    public void getShowSetting() {
        HepanShowSetting setting = service.getShowSetting();
        Assert.assertNotNull(setting);
    }

    @Test
    @Transactional
    public void setSetting() {

        HepanShowSetting hepanShowSetting = new HepanShowSetting();
        hepanShowSetting.setId(1);
        hepanShowSetting.setBanner(1);
        hepanShowSetting.setChannel(0);
        hepanShowSetting.setNotice(0);
        hepanShowSetting.setIndexBannerImg(1);
        service.setSetting(hepanShowSetting);
    }
}