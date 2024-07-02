package org.hepan.dataobject;


import lombok.Data;
import org.hepan.enums.ShipperEnableEnum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class HepanShipper {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String code;

    private Integer sortOrder;

    private String MonthCode;

    private String CustomerName;

    private Integer enabled = ShipperEnableEnum.UN_ABLE.getCode();
}
