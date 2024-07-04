package org.hepan.form;

import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class AdForm {

    private Integer id;

    private String link;

    private String imageUrl;

    private Integer linkType;

    private Integer goodsId;

    private Boolean enabled;

    private Date endTime;

    private Integer sortOrder;

    private Integer isDelete;
}
