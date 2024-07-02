package org.hepan.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.hepan.dataobject.HepanShowSetting;
import org.hepan.enums.ResEnums;
import org.hepan.exception.SysException;
import org.hepan.mapper.ShowSettingMapper;
import org.hepan.service.ShowSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class ShowSettingServiceImpl implements ShowSettingService {

    @Autowired
    ShowSettingMapper showSettingMapper;

    @Override
    public HepanShowSetting getShowSetting() {
        return showSettingMapper.findAll(null);
    }

    @Override
    @Transactional
    public void setSetting(HepanShowSetting setting){
        HepanShowSetting hepanSetting = showSettingMapper.findAll(setting.getId());
        log.info(setting.getId().toString());
        if(hepanSetting == null || setting.getId() == null){
            log.error("未找到该设置" + setting.getId());
            throw new SysException(ResEnums.SHOWSETTING_UNFIND);
        }
        showSettingMapper.updateSetting(setting);
    }
}
