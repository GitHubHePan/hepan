package org.hepan.mapper;


import org.apache.ibatis.annotations.Select;
import org.hepan.dataobject.HepanGoods;


public interface HepanGoodsMapper {

    @Select("select count(*) from hepan_goods where is_on_sale=1 and is_delete = 0")
    int countOnSale();

    @Select({"<script>",
            "select * from hepan_order_goods where order_id=#{id} "+
                "<if test='isDelete !=null and isDelete!=\"\"'>" +
                    "AND is_delete = #{isDelete}" +
                "</if>",
        "</script>"
    })
    HepanGoods getGoodsById(int id, Integer isDelete);



}
