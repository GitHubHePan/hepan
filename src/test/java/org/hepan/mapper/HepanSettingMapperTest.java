package org.hepan.mapper;

import org.hepan.dataobject.HepanSetting;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HepanSettingMapperTest {

    @Autowired
    HepanSettingMapper mapping;

    @Test
    public void countdownSetting() {
        Integer countDown = mapping.countdownSetting();
        Assert.assertNotNull(countDown);
    }

    @Test
    public void getSettingById() {
        HepanSetting setting = mapping.getSettingById();
        Assert.assertNotNull(setting);
    }
}