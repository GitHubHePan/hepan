package org.hepan.VO;

import lombok.Data;

import java.util.List;

@Data
public class PageListVO {

    private Integer currentPage;

    private Integer pageSize;

    private long count;

    private List data;

    private Integer totalPage;
}
