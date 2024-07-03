package org.hepan.mapper;

import org.hepan.VO.AdVO;
import org.hepan.dataobject.HepanAd;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdMapperTest {

    @Autowired
    private AdMapper adMapper;

    @Test
    public void findAdByAll() {
        List<HepanAd> hepanAd = adMapper.findAdAll();
        System.out.println(hepanAd);
        Assert.assertNotEquals(0, hepanAd.size() );
    }

    @Test
    public void findAdById() {
        HepanAd hepanAd = adMapper.findAdById(28);
        System.out.println(hepanAd);
        Assert.assertNotNull(hepanAd);
    }



    @Test
    @Transactional
    public void updateStatusById(){
        HepanAd hepanAd = adMapper.findAdById(28);
        hepanAd.setEnabled(0);
        Boolean flag = adMapper.updateAd(hepanAd);
        Assert.assertTrue(flag);
    }

    @Test
    @Transactional
    public void updateById() throws ParseException {
        HepanAd vo = new HepanAd();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        vo.setId(28);
        vo.setLinkType(1);
        vo.setEndTime(dateFormat.parse(dateFormat.format(new Date())));
        vo.setGoodsId(1109004);
        vo.setImageUrl("http://yanxuan.nosdn.127.net/ed50cbf7fab10b35f676e2451e112130.jpg");
        vo.setIsDelete(0);
        vo.setEnabled(0);
        vo.setSortOrder(10);
        Boolean flag = adMapper.updateAdById(vo);
        Assert.assertTrue(flag);
    }
}