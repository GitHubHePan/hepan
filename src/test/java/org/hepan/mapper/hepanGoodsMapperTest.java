package org.hepan.mapper;

import org.hepan.dataobject.HepanGoods;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class hepanGoodsMapperTest {

    @Autowired
    private HepanGoodsMapper goodsMapper;

    @Test
    public void countOnSale() {
        int count = goodsMapper.countOnSale();
        Assert.assertNotEquals(0,count);
    }

    @Test
    public void selectById() {
        HepanGoods goods = goodsMapper.getGoodsById(1006002, null);
        Assert.assertNotNull(goods);
    }

}