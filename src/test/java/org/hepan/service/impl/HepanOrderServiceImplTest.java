package org.hepan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hepan.dataobject.HepanOrder;
import org.hepan.mapper.HepanOrderMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HepanOrderServiceImplTest {

    @Autowired
    private HepanOrderServiceImpl hepanOrderService;

    @Test
    public void countHepanOrder() {
        Integer num  = hepanOrderService.countHapenOrders();
        Assert.assertNotNull(num);
    }

    @Test
    public void findHepanOrder() {
        PageInfo<HepanOrder> order = hepanOrderService.findHapenOrders(1,2, null, null, null);
        Assert.assertNotEquals(0, order.getList().size());
    }

}