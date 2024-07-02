package org.hepan.service.impl;

import org.hepan.dataobject.HepanSetting;
import org.hepan.mapper.HepanSettingMapper;
import org.hepan.service.UserSettingService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSettingServiceImplTest {

    @Autowired
    private UserSettingServiceImpl userSettingService;

    @Autowired
    private HepanSettingMapper hepanSettingMapper;

    @Test
    public void settingCountDown() {
        Integer countDown = userSettingService.settingCountDown();
        Assert.assertNotEquals(null, countDown);
    }

    @Test
    public void getSettingById() {
        HepanSetting setting = hepanSettingMapper.getSettingById();
        Assert.assertNotNull(setting);
    }
}