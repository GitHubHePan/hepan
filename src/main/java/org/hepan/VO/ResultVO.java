package org.hepan.VO;

import lombok.Data;

@Data
public class ResultVO<T> {

    public Integer code;

    public String msg;

    public T data;
}
