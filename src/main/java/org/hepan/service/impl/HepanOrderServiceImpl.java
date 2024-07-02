package org.hepan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hepan.dataobject.HepanOrder;
import org.hepan.mapper.HepanOrderMapper;
import org.hepan.service.HapenOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HepanOrderServiceImpl implements HapenOrderService {
    @Autowired
    HepanOrderMapper hepanOrderMapper;

    @Override
    public Integer countHapenOrders() {
        return hepanOrderMapper.countOrder();
    }

    @Override
    public PageInfo<HepanOrder> findHapenOrders(Integer page, Integer size, String orderSn, String consignee, List<String> status) {
        PageHelper.startPage(page,size);
        List<HepanOrder> order = hepanOrderMapper.selectAllOrder(orderSn, consignee, status);
        return new PageInfo<>(order);
    }



}
