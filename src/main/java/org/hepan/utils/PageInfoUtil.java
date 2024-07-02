package org.hepan.utils;


import com.github.pagehelper.PageInfo;
import org.hepan.VO.PageListVO;
import org.hepan.dataobject.HepanAd;
import org.springframework.stereotype.Component;

@Component
public class PageInfoUtil {


    public static <T> PageListVO setPageInfoUtil(PageInfo<T> pageInfo) {
        PageListVO pageListVO = new PageListVO();
        pageListVO.setTotalPage(pageInfo.getPages());
        pageListVO.setCurrentPage(pageInfo.getPageNum());
        pageListVO.setPageSize(pageInfo.getSize());
        pageListVO.setData(pageInfo.getList());
        pageListVO.setCount(pageInfo.getTotal());
        return pageListVO;
    }


}
