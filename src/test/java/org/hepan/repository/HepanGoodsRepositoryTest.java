package org.hepan.repository;

import lombok.extern.slf4j.Slf4j;
import org.hepan.dataobject.HepanGoods;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class HepanGoodsRepositoryTest {

    @Autowired
    private HepanGoodsRepository repository;

    @Test
    public void findAll() {
        List<HepanGoods> goods = repository.findAll();
        log.info(goods.toString());
        Assert.assertNotNull(goods);

    }
}