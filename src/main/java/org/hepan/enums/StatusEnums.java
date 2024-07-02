package org.hepan.enums;


import lombok.Getter;

@Getter
public enum StatusEnums {

    IS_DELETE(0, "未删除"),
    IS_UNDELETE(1,"未删除")
    ;

    private Integer Code;
    private String Description;

    StatusEnums(Integer Code, String Description) {
        this.Code = Code;
        this.Description = Description;
    }
}
