package com.team.azusa.yiyuan.model;

import java.util.Date;

/**
 * 用户云购商品记录表
 *
 * @author lvzf    2016年8月19日
 */
//@Entity
//@Table(name = "yyg_user_yg")
//@DynamicInsert
//@DynamicUpdate
public class UserYgEntity extends BaseEntity {
    /** */
    private static final long serialVersionUID = -5434273269333615583L;
    /**
     * 商品id
     */
    private Long productId;
    /**
     * 云购商品id
     */
    private Long ygProductId;
    /**
     * 云购商品
     */
//	@Transient
    private YgProductEntity ygProduct;
    /**
     * 当前期数
     */
//	@Column(columnDefinition = "int COMMENT '当前期数'")
    private long period;
    /**
     * 商品名称
     */
//	@Column(nullable = false, columnDefinition = "varchar(500) COMMENT '商品名称'")
    private String productName;
    /**
     * 总份数（总人次）
     */
//	@Column(nullable = false, columnDefinition = " bigint default 0 ")
    private long totalNum;
    /**
     * 单次购买价格
     */
//	@Column(nullable = false, columnDefinition = "bigint default 0 COMMENT '单次购买价格'")
    private long singlePrice;
    /**
     * 云购用户id
     */
    private Long buyUserId;
    /**
     * 云购用户昵称
     */
    private String buyUserNickName;

    /**
     * 云购用户头像
     */
    private String buyUserLogoPath;
    /**
     * 购买份数
     */
//	@Column(nullable = false, columnDefinition = "bigint default 0 COMMENT '购买份数'")
    private long buyNum;

    /**
     * 状态：0-未领奖，1-已领奖
     */
//	@Column(columnDefinition = "int default 0 COMMENT '状态：0-未领奖，1-已领奖'")
    private int status;

    public String getStatusName() {
        return (status == 0) ? "未领奖" : "已领奖";
    }

    /**
     * 购买（夺宝）时间
     */
//	@Column(columnDefinition = "bigint COMMENT '购买时间'")
    private Long buyDateLong;

    /**
     * 购买（夺宝）时间
     */
    public Date getBuyDate() {
        if (buyDateLong == null) {
            return null;
        }
        return new Date(buyDateLong);
    }

    /**
     * 随机购买的云购号码
     */
//	@Column(columnDefinition = "longtext COMMENT '随机购买的云购号码'")
    private String buyNos;

    /**
     * 是否中奖
     */
//	@Column(columnDefinition = "bit default false COMMENT '是否中奖'")
    private boolean win;
    /**
     * 中奖号码
     */
//	@Column(columnDefinition = "bigint COMMENT '中奖号码'")
    private Long winNo;

    /**
     * 支付交易id：支付完成才生成购买号码
     */
//	@Column(columnDefinition = "bigint COMMENT '支付交易id'")
    private Long payTradeId;
    /**
     * 客户端ip
     */
    private String clientIp;

    /**
     * ip地址
     */
    private String ipAddr;

    /**
     * get productId
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * set productId
     *
     * @param productId
     * @author lvzf 2016年8月27日
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * get ygProductId
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public Long getYgProductId() {
        return ygProductId;
    }

    /**
     * set ygProductId
     *
     * @param ygProductId
     * @author lvzf 2016年8月27日
     */
    public void setYgProductId(Long ygProductId) {
        this.ygProductId = ygProductId;
    }

    /**
     * get period
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public long getPeriod() {
        return period;
    }

    /**
     * set period
     *
     * @param period
     * @author lvzf 2016年8月27日
     */
    public void setPeriod(long period) {
        this.period = period;
    }

    /**
     * get productName
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public String getProductName() {
        return productName;
    }

    /**
     * set productName
     *
     * @param productName
     * @author lvzf 2016年8月27日
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * get totalNum
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public long getTotalNum() {
        return totalNum;
    }

    /**
     * set totalNum
     *
     * @param totalNum
     * @author lvzf 2016年8月27日
     */
    public void setTotalNum(long totalNum) {
        this.totalNum = totalNum;
    }

    /**
     * get singlePrice
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public long getSinglePrice() {
        return singlePrice;
    }

    /**
     * set singlePrice
     *
     * @param singlePrice
     * @author lvzf 2016年8月27日
     */
    public void setSinglePrice(long singlePrice) {
        this.singlePrice = singlePrice;
    }

    /**
     * get buyUserId
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public Long getBuyUserId() {
        return buyUserId;
    }

    /**
     * set buyUserId
     *
     * @param buyUserId
     * @author lvzf 2016年8月27日
     */
    public void setBuyUserId(Long buyUserId) {
        this.buyUserId = buyUserId;
    }

    /**
     * get buyUserNickName
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public String getBuyUserNickName() {
        return buyUserNickName;
    }

    /**
     * set buyUserNickName
     *
     * @param buyUserNickName
     * @author lvzf 2016年8月27日
     */
    public void setBuyUserNickName(String buyUserNickName) {
        this.buyUserNickName = buyUserNickName;
    }

    /**
     * get buyNum
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public long getBuyNum() {
        return buyNum;
    }

    /**
     * set buyNum
     *
     * @param buyNum
     * @author lvzf 2016年8月27日
     */
    public void setBuyNum(long buyNum) {
        this.buyNum = buyNum;
    }

    /**
     * get status
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public int getStatus() {
        return status;
    }

    /**
     * set status
     *
     * @param status
     * @author lvzf 2016年8月27日
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * get buyDateLong
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public Long getBuyDateLong() {
        return buyDateLong;
    }

    /**
     * set buyDateLong
     *
     * @param buyDateLong
     * @author lvzf 2016年8月27日
     */
    public void setBuyDateLong(Long buyDateLong) {
        this.buyDateLong = buyDateLong;
    }

    /**
     * get buyNos
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public String getBuyNos() {
        return buyNos;
    }

    /**
     * set buyNos
     *
     * @param buyNos
     * @author lvzf 2016年8月27日
     */
    public void setBuyNos(String buyNos) {
        this.buyNos = buyNos;
    }

    /**
     * get win
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public boolean isWin() {
        return win;
    }

    /**
     * set win
     *
     * @param win
     * @author lvzf 2016年8月27日
     */
    public void setWin(boolean win) {
        this.win = win;
    }

    /**
     * get winNo
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public Long getWinNo() {
        return winNo;
    }

    /**
     * set winNo
     *
     * @param winNo
     * @author lvzf 2016年8月27日
     */
    public void setWinNo(Long winNo) {
        this.winNo = winNo;
    }

    /**
     * get payTradeId
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public Long getPayTradeId() {
        return payTradeId;
    }

    /**
     * set payTradeId
     *
     * @param payTradeId
     * @author lvzf 2016年8月27日
     */
    public void setPayTradeId(Long payTradeId) {
        this.payTradeId = payTradeId;
    }

    /**
     * get buyUserLogoPath
     *
     * @return
     * @author lvzf 2016年8月29日
     */
    public String getBuyUserLogoPath() {
        return buyUserLogoPath;
    }

    /**
     * set buyUserLogoPath
     *
     * @param buyUserLogoPath
     * @author lvzf 2016年8月29日
     */
    public void setBuyUserLogoPath(String buyUserLogoPath) {
        this.buyUserLogoPath = buyUserLogoPath;
    }

    /**
     * get clientIp
     *
     * @return
     * @author lvzf 2016年9月5日
     */
    public String getClientIp() {
        return clientIp;
    }

    /**
     * set clientIp
     *
     * @param clientIp
     * @author lvzf 2016年9月5日
     */
    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    /**
     * get ipAddr
     *
     * @return
     * @author lvzf 2016年9月5日
     */
    public String getIpAddr() {
        return ipAddr;
    }

    /**
     * set ipAddr
     *
     * @param ipAddr
     * @author lvzf 2016年9月5日
     */
    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    /**
     * get ygProduct
     *
     * @return
     * @author lvzf 2016年9月25日
     */
    public YgProductEntity getYgProduct() {
        return ygProduct;
    }

    /**
     * set ygProduct
     *
     * @param ygProduct
     * @author lvzf 2016年9月25日
     */
    public void setYgProduct(YgProductEntity ygProduct) {
        this.ygProduct = ygProduct;
    }

}
