package org.hepan.service;

import com.github.pagehelper.PageInfo;
import org.hepan.VO.AdVO;
import org.hepan.dataobject.HepanAd;


public interface AdService {
    PageInfo<AdVO> findeAll(Integer pageNum, Integer pageSize);


    Boolean updateAdStatus(Integer id, Boolean status);

    HepanAd findById(Integer id);
}
