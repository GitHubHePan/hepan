package org.hepan.service.impl;

import org.hepan.mapper.HepanGoodsMapper;
import org.hepan.service.HepanGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HepanGoodsImpl implements HepanGoods {

    @Autowired
    private HepanGoodsMapper  hepanGoodsMapper;

    @Override
    public Integer countGoodOnSale(){
        return hepanGoodsMapper.countOnSale();
    }
}
