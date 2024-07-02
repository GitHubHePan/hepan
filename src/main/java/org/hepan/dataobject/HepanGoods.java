package org.hepan.dataobject;

import lombok.Data;
import org.hepan.enums.GoodsStatusEnums;
import org.hepan.enums.StatusEnums;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
public class HepanGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    public Integer id;

    public String name;

    public Integer categoryId;

    public Integer isOnSale= GoodsStatusEnums.IS_ON_SALE.getCode();

    public Integer goodsNumber;

    public Integer sellVolume;

    public String keywords;

    public BigDecimal retailPrice;

    public BigDecimal minRetailPrice;

    public BigDecimal costPrice;

    public BigDecimal minCostPrice;

    public String goodsBrief;

    public String goodsDesc;

    public Integer sortOrder;
    /** 0不放在首页 1放到首页 */
    public Integer isIndex= 0;

    public Integer isNew= 0;

    public String goodsUnit;

    public String httpsPicUrl;

    public String listPicUrl;

    public Integer freightTemplateId;

    public Integer freightType= 0;

    public Integer isDelete= StatusEnums.IS_DELETE.getCode();

}
