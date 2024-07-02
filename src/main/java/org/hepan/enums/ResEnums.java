package org.hepan.enums;


import lombok.Getter;

@Getter
public enum ResEnums {

    SUCCESS(0, "成功"),
    PARAMS_ERROR( 1, "参数不正确"),
    USER_NOT_FOUND(2, "用户不存在"),
    POSSWORD_ERROR(3, "密码不正确"),
    PLEASE_LOGIN(4, "请登录"),
    TOKEN_EXPIRE(401, "登录过期，请重新登录"),
    SHOWSETTING_UNFIND(5, "show setting未找到"),
    AD_NOT_FOUND(6, "ad未找到")
    ;

    private Integer Code;
    private String Description;
    ResEnums(Integer Code, String Description) {
        this.Code = Code;
        this.Description = Description;
    }

}
