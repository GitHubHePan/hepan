package org.hepan.mapper;

import org.apache.ibatis.annotations.*;
import org.hepan.dataobject.HepanShowSetting;

import java.util.List;

public interface ShowSettingMapper {

    @Select({"<script>",
            "select * from hepan_show_settings"+
                    "<if test='id != null and id!= \"\"' >"+
                        "where id = #{id}"+
                    "</if>",
            "</script>"
    })
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "indexBannerImg", column = "index_banner_img"),
    })
    HepanShowSetting findAll(Integer id);

    @Update({"update hepan_show_settings set " +
            "banner = #{banner}, " +
            "channel = #{channel}, " +
            "notice=#{notice}, " +
            "index_banner_img=#{indexBannerImg} " +
            "where id = #{id}"})
    void updateSetting(HepanShowSetting setting);

}
