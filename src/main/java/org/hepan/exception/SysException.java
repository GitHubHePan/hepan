package org.hepan.exception;

import lombok.Getter;
import org.hepan.enums.ResEnums;

@Getter
public class SysException extends RuntimeException{
    private Integer code;
    public SysException(ResEnums enums) {
        super(enums.getDescription());
        this.code = enums.getCode();
    }

    public SysException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
