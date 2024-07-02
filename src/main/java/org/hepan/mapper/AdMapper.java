package org.hepan.mapper;


import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.hepan.dataobject.HepanAd;

import java.util.List;

public interface AdMapper {

    @Select("select * from hepan_ad ORDER BY id ASC")
    List<HepanAd> findAdAll();

    @Select("select * from hepan_ad where id=#{id}")
    HepanAd findAdById(int id);

    @Update("update hepan_ad set enabled = #{enabled} where id = #{id}")
    Boolean updateAd(HepanAd ad);

    @Update("update ")
}
