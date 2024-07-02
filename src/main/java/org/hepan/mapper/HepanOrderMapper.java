package org.hepan.mapper;

import org.apache.ibatis.annotations.*;
import org.hepan.dataobject.HepanOrder;

import java.util.List;
import java.util.Map;

public interface HepanOrderMapper {

    @Select("select count(*) from hepan_order where order_status= 300")
    int countOrder();

    @Select("select * from hepan_order where id= #{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "goodsList",column = "id",
                    javaType = List.class,
                    many = @Many(select = "org.hepan.mapper.HepanGoodsMapper.getGoodsById")),
    })
    int getOrderDetailById(int id);

    @Select({"<script>",
            " select * from hepan_order where order_type &lt; 7",
                "<if test='order_Sn !=null and order_Sn!=\"\"'>" +
                    "AND order_sn like concat('%',#{order_Sn},'%')" +
                "</if>" +
                "<if test='consignee !=null and consignee!=\"\"'>" +
                    "AND consignee like concat('%',#{consignee},'%')" +
                "</if>" +
                "<if test='status !=null and status!=\"\"'>" +
                        "AND order_status IN" +
                        "<foreach item='item'  collection='status' open='(' separator=',' close=')'>"+
                            "#{item}"+
                        "</foreach>"+
                "</if>",
            "</script>"
    })
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "orderNo", column = "order_no" ),
            @Result(property = "goodsList",column = "id",
                    javaType = List.class,
                    many = @Many(select = "org.hepan.mapper.HepanGoodsMapper.getGoodsById")),
            @Result(property = "userInfo",column = "user_id",
                    javaType = Map.class,
                    one = @One(select = "org.hepan.mapper.HepanUserMapper.selectUserById")),

    })
    List<HepanOrder> selectAllOrder(@Param("order_Sn") String order_Sn, @Param("consignee") String consignee, @Param("status") List<String> status);

}
