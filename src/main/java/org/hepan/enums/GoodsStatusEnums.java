package org.hepan.enums;

import lombok.Getter;

@Getter
public enum GoodsStatusEnums {

    IS_ON_SALE(1, "在售"),
    IS_ONT_SALE(0, "下架")
    ;

    private Integer Code;
    private String Description;
    GoodsStatusEnums(Integer Code, String Description) {
        this.Code = Code;
        this.Description = Description;
    }

}
