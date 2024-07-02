package org.hepan.dataobject;


import lombok.Data;
import org.hepan.enums.StatusEnums;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class HepanOrderGoods {

    @Id
    private Integer id;

    private Integer orderId;

    private Integer goodsId;

    private String goodsName;

    private String goodsAka;

    private Integer productId;

    private Integer number;

    private BigDecimal retailPrice;

    private String  goodsSpecifitionNameValue;

    private String  goodsSpecifitionIds;

    private String  listPicUrl;

    private Integer userId;

    private Integer isDelete= StatusEnums.IS_DELETE.getCode();
}
