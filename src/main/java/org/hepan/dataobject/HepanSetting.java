package org.hepan.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class HepanSetting {

    @Id
    private Integer id;

    private String Name;

    private Integer autoDelivery=0;

    private String Tel;

    private String ProvinceName;

    private String CityName;

    private String ExpAreaName;

    private String Address;

    private Integer discoveryImgHeight=0;

    private String discoveryImg;

    private Integer goodsId=0;

    private Integer cityId=0;

    private Integer provinceId=0;

    private Integer districtId=0;

    private Integer countdown=0;

    private Integer reset=0;
}
