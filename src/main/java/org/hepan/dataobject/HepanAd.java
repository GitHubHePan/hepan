package org.hepan.dataobject;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class HepanAd implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private String link;

    private String imageUrl;

    private Integer linkType;

    private Integer goodsId;

    private Integer enabled;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    private Integer sortOrder;

    private Integer isDelete;
}
