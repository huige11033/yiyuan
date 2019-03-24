package com.team.azusa.yiyuan.model;

import java.util.Date;

//import cn.com.easy.persistence.BaseEntity;
//import cn.com.easy.utils.FastJSONUtils;
//import cn.com.yyg.base.eum.YgProductOrderStatusEnum;

/**
 * 云购订单（中奖后获取产品）
 *
 * @author lvzf    2016年10月9日
 */
//@Entity
//@Table(name = "yyg_yg_order")
//@DynamicInsert
//@DynamicUpdate
public class YgProductOrderEntity extends BaseEntity {

    /** */
    private static final long serialVersionUID = -1878160890179691354L;
    /**
     * 中奖用户
     */
    private Long userId;
    /**
     * 云购记录id
     */
    private Long userYgId;
    /**
     * 商品云购json
     */
//    @Column(columnDefinition = "varchar(3000) COMMENT '商品云购json'")
    private String ygProductJson;

//    public YgProductEntity getYgProduct() {
//        return FastJSONUtils.toObject(ygProductJson, YgProductEntity.class);
//    }

    /**
     * YgProductOrderStatusEnum 状态（1-已付款，2-已发货，3-已收货，4-交易完成）
     */
    private Integer status;

//    public String getStatusName() {
//        return YgProductOrderStatusEnum.getName(status);
//    }

    /**
     * 订单号：时间戳
     */
    private String orderId;
    /**
     * 交易完成晒单id
     */
    private Long shareId;
    /**
     * 收货地址json
     */
//    @Column(columnDefinition = "varchar(3000) COMMENT '收货地址json'")
    private String addrJson;

//    public AddressEntity getAddress() {
//        return FastJSONUtils.toObject(addrJson, AddressEntity.class);
//    }

    /**
     * 备注id
     */
    private String remark;
    /**
     * 快递公司
     */
//    @Column(columnDefinition = "varchar(3000) COMMENT '快递公司json'")
    private String expComJson;

    /**
     * 快递公司
     */
//    public ExpressComEntity getExpressCom() {
//        return FastJSONUtils.toObject(expComJson, ExpressComEntity.class);
//    }

    /**
     * 快递号
     */
    private String expNo;
    /**
     * 发货时间
     */
    private Date sendTime;
    /**
     * 收货时间
     */
    private Date acceptTime;
    /**
     * 分享时间
     */
    private Date shareTime;
    /**
     * 发货备注
     */
    private String sendRemark;

    /**
     * get userId
     *
     * @return
     * @author lvzf 2016年10月9日
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * set userId
     *
     * @param userId
     * @author lvzf 2016年10月9日
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * get userYgId
     *
     * @return
     * @author lvzf 2016年10月9日
     */
    public Long getUserYgId() {
        return userYgId;
    }

    /**
     * set userYgId
     *
     * @param userYgId
     * @author lvzf 2016年10月9日
     */
    public void setUserYgId(Long userYgId) {
        this.userYgId = userYgId;
    }

    /**
     * get status
     *
     * @return
     * @author lvzf 2016年10月9日
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * set status
     *
     * @param status
     * @author lvzf 2016年10月9日
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * get shareId
     *
     * @return
     * @author lvzf 2016年10月9日
     */
    public Long getShareId() {
        return shareId;
    }

    /**
     * set shareId
     *
     * @param shareId
     * @author lvzf 2016年10月9日
     */
    public void setShareId(Long shareId) {
        this.shareId = shareId;
    }

    /**
     * get addrJson
     *
     * @return
     * @author lvzf 2016年10月9日
     */
    public String getAddrJson() {
        return addrJson;
    }

    /**
     * set addrJson
     *
     * @param addrJson
     * @author lvzf 2016年10月9日
     */
    public void setAddrJson(String addrJson) {
        this.addrJson = addrJson;
    }

    /**
     * get remark
     *
     * @return
     * @author lvzf 2016年10月9日
     */
    public String getRemark() {
        return remark;
    }

    /**
     * set remark
     *
     * @param remark
     * @author lvzf 2016年10月9日
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * get expComJson
     *
     * @return
     * @author lvzf 2016年10月11日
     */
    public String getExpComJson() {
        return expComJson;
    }

    /**
     * set expComJson
     *
     * @param expComJson
     * @author lvzf 2016年10月11日
     */
    public void setExpComJson(String expComJson) {
        this.expComJson = expComJson;
    }

    /**
     * get expNo
     *
     * @return
     * @author lvzf 2016年10月9日
     */
    public String getExpNo() {
        return expNo;
    }

    /**
     * set expNo
     *
     * @param expNo
     * @author lvzf 2016年10月9日
     */
    public void setExpNo(String expNo) {
        this.expNo = expNo;
    }

    /**
     * get orderId
     *
     * @return
     * @author lvzf 2016年10月9日
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * set orderId
     *
     * @param orderId
     * @author lvzf 2016年10月9日
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * get ygProductJson
     *
     * @return
     * @author lvzf 2016年10月10日
     */
    public String getYgProductJson() {
        return ygProductJson;
    }

    /**
     * set ygProductJson
     *
     * @param ygProductJson
     * @author lvzf 2016年10月10日
     */
    public void setYgProductJson(String ygProductJson) {
        this.ygProductJson = ygProductJson;
    }

    /**
     * get sendRemark
     *
     * @return
     * @author lvzf 2016年10月11日
     */
    public String getSendRemark() {
        return sendRemark;
    }

    /**
     * set sendRemark
     *
     * @param sendRemark
     * @author lvzf 2016年10月11日
     */
    public void setSendRemark(String sendRemark) {
        this.sendRemark = sendRemark;
    }

    /**
     * get sendTime
     *
     * @return
     * @author lvzf 2016年10月11日
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * set sendTime
     *
     * @param sendTime
     * @author lvzf 2016年10月11日
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * get acceptTime
     *
     * @return
     * @author lvzf 2016年10月11日
     */
    public Date getAcceptTime() {
        return acceptTime;
    }

    /**
     * set acceptTime
     *
     * @param acceptTime
     * @author lvzf 2016年10月11日
     */
    public void setAcceptTime(Date acceptTime) {
        this.acceptTime = acceptTime;
    }

    /**
     * get shareTime
     *
     * @return
     * @author lvzf 2016年10月11日
     */
    public Date getShareTime() {
        return shareTime;
    }

    /**
     * set shareTime
     *
     * @param shareTime
     * @author lvzf 2016年10月11日
     */
    public void setShareTime(Date shareTime) {
        this.shareTime = shareTime;
    }


}
