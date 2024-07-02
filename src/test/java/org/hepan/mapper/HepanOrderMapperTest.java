package org.hepan.mapper;

import jdk.nashorn.internal.runtime.UnwarrantedOptimismException;
import org.hepan.dataobject.HepanOrder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HepanOrderMapperTest {

    @Autowired
    HepanOrderMapper hepanOrderMapper;

    @Test
    public void findAllStatus300(){
        int count = hepanOrderMapper.countOrder();
        Assert.assertNotEquals(0,count);
    }

    @Test
    public void findAll(){

        List<String> arr = new ArrayList<>();
        arr.add("300");
        arr.add("102");
        String[] a = new String[arr.size()];
        List<HepanOrder> hepanOrder = hepanOrderMapper.selectAllOrder(null, null, arr);
        System.out.println(hepanOrder.size());
        Assert.assertNotEquals(0, hepanOrder.size());
    }


}