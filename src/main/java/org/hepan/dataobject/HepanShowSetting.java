package org.hepan.dataobject;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@TableName("hepan_show_settings")
public class HepanShowSetting {

    @Id
    private Integer id;

    private Integer banner;

    private Integer channel;

    @TableField("index_banner_img")
    private Integer indexBannerImg;

    private Integer notice;

}
