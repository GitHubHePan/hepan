package org.hepan.enums;

import lombok.Getter;

@Getter
public enum ShipperEnableEnum {

    IS_ABLE(1, "可用"),
    UN_ABLE(0, "不可用")
    ;


    private Integer Code;
    private String Description;

    private ShipperEnableEnum(Integer Code, String Description) {
        this.Code = Code;
        this.Description = Description;
    }

}
