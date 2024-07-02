package org.hepan.form;

import lombok.Data;
import org.hepan.enums.ResEnums;

import javax.validation.constraints.NotEmpty;

@Data
public class ShowSettingForm {

    @NotEmpty(message= "id 必须")
    private Integer id;

    private Integer banner;

    private Integer channel;

    private Integer indexBannerImg;

    private Integer notice;

}
