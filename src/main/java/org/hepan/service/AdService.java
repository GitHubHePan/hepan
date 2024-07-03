package org.hepan.service;

import com.github.pagehelper.PageInfo;
import org.hepan.VO.AdVO;
import org.hepan.dataobject.HepanAd;
import org.hepan.form.AdForm;


public interface AdService {
    PageInfo<AdVO> findeAll(Integer pageNum, Integer pageSize);


    Boolean updateAdStatus(Integer id, Boolean status);

    AdVO findById(Integer id);

    Boolean updateAdById(AdForm ad);
}
