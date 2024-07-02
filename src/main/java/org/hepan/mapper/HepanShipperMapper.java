package org.hepan.mapper;

import org.apache.ibatis.annotations.Select;
import org.hepan.dataobject.HepanShipper;

import java.util.List;

public interface HepanShipperMapper {

    @Select("select * from hepan_shipper where enabled = 1")
    public List<HepanShipper> selectAll();

}
