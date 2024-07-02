package org.hepan.mapper;

import org.hepan.dataobject.HepanShowSetting;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShowSettingMapperTest {

    @Autowired
    ShowSettingMapper showSettingMapper;

    @Test
    public void findAll() {
        HepanShowSetting hepanShowSetting = showSettingMapper.findAll(null);
        Assert.assertNotEquals(Optional.of(1), hepanShowSetting.getId());
    }

    @Test
    @Transactional
    public void updateSetting() {

        HepanShowSetting hepanShowSetting = new HepanShowSetting();
        hepanShowSetting.setId(1);
        hepanShowSetting.setBanner(1);
        hepanShowSetting.setChannel(0);
        hepanShowSetting.setNotice(0);
        hepanShowSetting.setIndexBannerImg(1);

        showSettingMapper.updateSetting(hepanShowSetting);

    }
}