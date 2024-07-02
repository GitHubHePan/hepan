package org.hepan.dataobject;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@Entity
public class HepanRegion {

    @Id
    private Integer id;

    private String name;

    private Integer parentId;

    private Integer type;

    private Integer agencyId;

    private Integer area;

    private String areaCode;

    private String farArea;

    @OneToMany
    @TableField(exist = false)
    private List<HepanRegion> children;
}
