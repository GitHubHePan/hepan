package org.hepan.mapper;

import org.hepan.dataobject.HepanUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class HepanUserMapperTest {

    @Autowired
    private HepanUserMapper hepanUserMapper;

    @Test
    public void countUser() {
        Integer count = hepanUserMapper.countUser();
        System.out.println(count);
        Assert.assertNotNull(count);
    }

    @Test
    public void selectUserById() {
        HepanUser hepanUser = hepanUserMapper.selectUserById("hepan");
        Assert.assertNotNull(hepanUser);
    }
}