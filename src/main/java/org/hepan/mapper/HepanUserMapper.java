package org.hepan.mapper;

import org.apache.ibatis.annotations.Select;
import org.hepan.dataobject.HepanUser;

public interface HepanUserMapper {

    @Select("select COUNT(*) from hepan_user")
    Integer countUser();

    @Select("select nickname,name,mobile,avatar from hepan_user where id=#{userId}")
    HepanUser selectUserById(String userId);
}
