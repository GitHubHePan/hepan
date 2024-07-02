package org.hepan.service.impl;

import org.hepan.dataobject.HepanSetting;
import org.hepan.dataobject.HepanShowSetting;
import org.hepan.mapper.HepanSettingMapper;
import org.hepan.mapper.HepanUserMapper;
import org.hepan.service.UserSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSettingServiceImpl implements UserSettingService {

    @Autowired
    HepanUserMapper hepanUserMapper;

    @Autowired
    HepanSettingMapper hepanSettingMapper;

    @Override
    public Integer settingCountDown(){
        return hepanUserMapper.countUser();
    }

    @Override
    public HepanSetting getSettingById(){
        return hepanSettingMapper.getSettingById();
    }



}
