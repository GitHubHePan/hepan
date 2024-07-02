package org.hepan.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegionVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int value;
    private String label;
    private List<RegionVO> children;


}
