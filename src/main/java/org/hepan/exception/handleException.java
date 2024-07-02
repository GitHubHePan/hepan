package org.hepan.exception;


import lombok.extern.slf4j.Slf4j;
import org.hepan.VO.ResultVO;
import org.hepan.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class handleException {

    @ExceptionHandler(SysException.class)
    @ResponseBody
    public ResultVO handleException(SysException e) {
        log.error(e.getMessage(), e);
        return ResultUtil.error(e.getCode(), e.getMessage());
    }
}
