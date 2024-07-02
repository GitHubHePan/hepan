package org.hepan.service;

import org.hepan.dataobject.HepanShowSetting;

public interface ShowSettingService {
    HepanShowSetting getShowSetting();

    void setSetting(HepanShowSetting setting);
}
