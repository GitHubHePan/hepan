package org.hepan.mapper;

import org.apache.ibatis.annotations.Select;
import org.hepan.dataobject.HepanSetting;

public interface HepanSettingMapper {

    @Select("select countdown from hepan_settings")
    Integer countdownSetting();

    @Select("select autoDelivery from hepan_settings where id = 1")
    HepanSetting getSettingById();
}
