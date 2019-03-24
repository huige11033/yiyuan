package com.team.azusa.yiyuan.model;

import java.math.BigDecimal;
import java.util.Date;

//import com.google.common.collect.Lists;
//
//import org.apache.commons.lang3.StringUtils;

//import cn.com.easy.persistence.BaseEntity;
//import cn.com.easy.utils.FastJSONUtils;
//import cn.com.easy.utils.JacksonJsonDateSerializer;

//@Entity
//@Table(name = "ygg_pay_record")
//@DynamicInsert
//@DynamicUpdate
public class PayRecordEntity extends BaseEntity {

    /** */
    private static final long serialVersionUID = -7568391191456219246L;
    /**
     * 支付状态：待付款
     */
    public static final int PAY_STATUS_INIT = 0;
    /**
     * 支付状态：已付款
     */
    public static final int PAY_STATUS_SUCCESS = 1;
    /**
     * 支付状态：付款失败
     */
    public static final int PAY_STATUS_FAIL = 2;
    /**
     * 支付状态：付款过期关闭
     */
    public static final int PAY_STATUS_DUE_CLOSE = 3;
    /**
     * 支付宝支付
     */
    public static final int PAY_TYPE_ALI = 1;
    /**
     * 微信支付
     */
    public static final int PAY_TYPE_WX = 2;
    /**
     * 银联在线
     */
    public static final int PAY_TYPE_UNION = 3;
    /**
     * 余额付款
     */
    public static final int PAY_TYPE_YUE = 4;
    /**
     * 积分支付
     */
    public static final int PAY_TYPE_JIFEN = 5;
    /**
     * 付款用户id
     */
//	@Column(nullable = false)
    private Long userId;
    /**
     * 付款用户
     */
    private String userName;
    /**
     * 付款金额
     */
//	@Column(nullable = false, columnDefinition = " bigint default 0 ")
    private BigDecimal amount;
    /**
     * 支付状态
     */
//	@Column(nullable = false, columnDefinition = " int default 0 ")
    private Integer payStatus;

    /**
     * 支付状态名称
     */
    public String getPayStatusName() {
        if (payStatus == PAY_STATUS_INIT) {
            return "待付款";
        } else if (payStatus == PAY_STATUS_SUCCESS) {
            return "已付款";
        } else {
            return "付款失败";
        }
    }

    /**
     * 支付方式
     */
//	@Column(nullable = false, columnDefinition = " int default 0 ")
    private Integer payType;

    /**
     * 支付方式名称
     */
    public String getPayTypeName() {
        if (payType == PAY_TYPE_ALI) {
            return "支付宝付款";
        } else if (payType == PAY_TYPE_WX) {
            return "微信付款";
        } else if (payType == PAY_TYPE_UNION) {
            return "银联在线";
        } else {
            return "余额付款";
        }
    }

    /**
     * 购物车提交过来的数据
     */
    private String carts;

//    public List<YgCartEntity> getCartList() {
//        if (StringUtils.isNoneBlank(carts)) {
//            return FastJSONUtils.toArray(carts, YgCartEntity.class);
//        }
//        return Lists.newArrayList();
//    }

    /**
     * 支付流水号
     */
    private String payNo;
    /**
     * 本系统支付时间
     */
    private Date payTime;
    /**
     * 第三方系统支付时间
     */
    private Date thirdPayTime;
    /**
     * 第三方支付（支付宝）交易号
     */
    private String thirdTradeNo;
    /**
     * 第三方支付（支付宝）状态
     */
    private String thirdTradeStatus;

    /**
     * get userId
     *
     * @return
     * @author lvzf 2016年9月22日
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * set userId
     *
     * @param userId
     * @author lvzf 2016年9月22日
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * get userName
     *
     * @return
     * @author lvzf 2016年9月22日
     */
    public String getUserName() {
        return userName;
    }

    /**
     * set userName
     *
     * @param userName
     * @author lvzf 2016年9月22日
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * get aAmount
     *
     * @return
     * @author lvzf 2016年9月22日
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * set aAmount
     *
     * @param amount
     * @author lvzf 2016年9月22日
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * get payStatus
     *
     * @return
     * @author lvzf 2016年9月22日
     */
    public Integer getPayStatus() {
        return payStatus;
    }

    /**
     * set payStatus
     *
     * @param payStatus
     * @author lvzf 2016年9月22日
     */
    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * get payType
     *
     * @return
     * @author lvzf 2016年9月22日
     */
    public Integer getPayType() {
        return payType;
    }

    /**
     * set payType
     *
     * @param payType
     * @author lvzf 2016年9月22日
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * get payNo
     *
     * @return
     * @author lvzf 2016年9月22日
     */
    public String getPayNo() {
        return payNo;
    }

    /**
     * set payNo
     *
     * @param payNo
     * @author lvzf 2016年9月22日
     */
    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    /**
     * get payTime
     *
     * @return
     * @author lvzf 2016年9月22日
     */
//    @JsonSerialize(using = JacksonJsonDateSerializer.class)
    public Date getPayTime() {
        return payTime;
    }

    /**
     * set payTime
     *
     * @param payTime
     * @author lvzf 2016年9月22日
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * get thirdPayTime
     *
     * @return
     * @author lvzf 2016年9月22日
     */
//    @JsonSerialize(using = JacksonJsonDateSerializer.class)
    public Date getThirdPayTime() {
        return thirdPayTime;
    }

    /**
     * set thirdPayTime
     *
     * @param thirdPayTime
     * @author lvzf 2016年9月22日
     */
    public void setThirdPayTime(Date thirdPayTime) {
        this.thirdPayTime = thirdPayTime;
    }

    /**
     * get thirdTradeNo
     *
     * @return
     * @author lvzf 2016年9月22日
     */
    public String getThirdTradeNo() {
        return thirdTradeNo;
    }

    /**
     * set thirdTradeNo
     *
     * @param thirdTradeNo
     * @author lvzf 2016年9月22日
     */
    public void setThirdTradeNo(String thirdTradeNo) {
        this.thirdTradeNo = thirdTradeNo;
    }

    /**
     * get thirdTradeStatus
     *
     * @return
     * @author lvzf 2016年9月22日
     */
    public String getThirdTradeStatus() {
        return thirdTradeStatus;
    }

    /**
     * set thirdTradeStatus
     *
     * @param thirdTradeStatus
     * @author lvzf 2016年9月22日
     */
    public void setThirdTradeStatus(String thirdTradeStatus) {
        this.thirdTradeStatus = thirdTradeStatus;
    }

    /**
     * set carts
     *
     * @param carts
     * @author lvzf 2016年9月22日
     */
    public void setCarts(String carts) {
        this.carts = carts;
    }

    /**
     * get carts
     *
     * @return
     * @author lvzf 2016年9月22日
     */
    public String getCarts() {
        return carts;
    }

}
