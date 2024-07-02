package org.hepan.controller;


import lombok.extern.slf4j.Slf4j;
import org.hepan.VO.ResultVO;
import org.hepan.dataobject.HepanUser;
import org.hepan.enums.ResEnums;
import org.hepan.exception.SysException;
import org.hepan.form.LoginForm;
import org.hepan.service.AuthService;
import org.hepan.utils.JwtTokenUtil;
import org.hepan.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

//用户使用账号和密码发出post请求；
//服务器使用私钥创建一个jwt；
//服务器返回这个jwt给浏览器；
//浏览器将该jwt串在请求头中像服务器发送请求；
//服务器验证该jwt；
//返回响应的资源给浏览器。

@RestController
@RequestMapping(value = "/auth")
//@CrossOrigin(origins = "*")
@Slf4j
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultVO login(@Valid @RequestBody LoginForm loginForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            return ResultUtil.error(ResEnums.PARAMS_ERROR.getCode(), msg);
        }
        HepanUser user = authService.findByUserId(loginForm.username);
        if (user == null) {
            throw new SysException(ResEnums.USER_NOT_FOUND);
        }
        String passwordMd5 = DigestUtils.md5DigestAsHex((user.getSalt() + loginForm.getPassword()).getBytes(StandardCharsets.UTF_8));
        log.info(passwordMd5);
        if(!passwordMd5.equals(user.getPassword())) {
            throw new SysException(ResEnums.POSSWORD_ERROR);
        }
        Map map = new HashMap();
        map.put("username", loginForm.username);
        map.put("mobile", user.getMobile());

        String token =  jwtTokenUtil.generateToken(map);
        log.info(token);

        Map tokenMap = new HashMap();
        tokenMap.put("token", token);

        return ResultUtil.success(tokenMap);
    }
}
