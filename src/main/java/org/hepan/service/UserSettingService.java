package org.hepan.service;

import org.hepan.dataobject.HepanSetting;
import org.hepan.dataobject.HepanShowSetting;

public interface UserSettingService {

    Integer settingCountDown();

    HepanSetting getSettingById();


}
