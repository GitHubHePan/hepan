package org.hepan.form;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginForm {

    @NotEmpty(message="账号不可为空")
    public String username;

    @NotEmpty(message="密码不可为空")
    public String password;
}
