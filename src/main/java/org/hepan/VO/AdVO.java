package org.hepan.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class AdVO {
    @Id
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
