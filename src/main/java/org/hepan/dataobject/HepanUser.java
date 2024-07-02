package org.hepan.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class HepanUser {

    @Id
    public String id;

    public String nickname;

    public String name;

    public String username;

    public String salt;

    public String password;

    public Integer gender= 0;

    public Integer birthday= 0;

    public Date registerTime;

    public Date lastLoginTime;

    public String lastLoginIp;

    public String mobile;

    public String registerIp;

    public String avatar;

    public String weixinOpenid;

    public String nameMobile;

    public String country;

    public String province;

    public String city;

}
