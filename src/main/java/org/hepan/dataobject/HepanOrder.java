package org.hepan.dataobject;

//import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.hepan.enums.StatusEnums;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class HepanOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private String orderNo;

    private String userId;
    //'101：未付款、102：已取消、103已取消(系统)、201：已付款、202：订单取消，退款中、203：已退款、301：已发货、302：已收货、303：已收货(系统)、401：已完成、801：拼团中,未付款、802：拼团中,已付款'
    private String orderStatus;
    //'线下支付订单标志'
    private Integer offlinePay = 0;
    //'0未发货，1已发货'
    private Integer shippingStatus = 0;

    private Integer payStatus = 0;

    private String consignee;

    private Integer country=0;

    private Integer province=0;

    private Integer city=0;

    private Integer district=0;

    private String address;

    private String printInfo;

    private String mobile;

    private String postscript;

    private String adminMemo;

    private BigDecimal shippingFee;

    private String payName;

    private String payId;

    private BigDecimal changePrice;

    private BigDecimal actualPrice;

    private BigDecimal orderPrice;

    private BigDecimal goodsPrice;

    private Integer addtime;

    private Integer payTime;

    private Integer shippingTime;

    private Integer confirmTime;

    private Integer dealdoneTime;

    private Integer freightPrice;

    private Integer expressValue;

    private String remark;

    private Integer orderType = 0;

    private Integer isDelete= StatusEnums.IS_DELETE.getCode();

    @OneToMany
    @TableField(exist = false)
    private List<HepanGoods> goodsList;

    @OneToOne
    @TableField(exist = false)
    private HepanUser userInfo;
}
