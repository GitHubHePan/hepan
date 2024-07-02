package org.hepan.mapper;

import org.apache.ibatis.annotations.*;
import org.hepan.dataobject.HepanRegion;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface HepanRegionMapper {

    @Select("select * from hepan_region where parent_id = #{parentId}" )
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "children",column = "id",
                    javaType = List.class,
                    many = @Many(select = "org.hepan.mapper.HepanRegionMapper.selectAll")),
    })
    List<HepanRegion> selectAll(@Param("parentId") Integer parentId);
}
