package com.team.azusa.yiyuan.model;

/**
 * 购物车实体
 *
 * @author lvzf 2016年8月26日
 */
//@Entity
//@Table(name = "yyg_yg_cart")
//@DynamicInsert
//@DynamicUpdate
public class YgCartEntity extends BaseEntity {
    /** */
    private static final long serialVersionUID = -3174535157340972887L;
    private Long userId;
    /**
     * 云购商品
     */
//	@Column(nullable = false)
    private Long ygProductId;
    /**
     * 数量
     */
//	@Column(nullable = false, columnDefinition = " bigint default 1 ")
    private long buyNum;
    /**
     * 客户端ip
     */
    private String clientIp;

    /**
     * ip地址
     */
    private String ipAddr;

    /**
     * get userId
     *
     * @return
     * @author lvzf 2016年8月26日
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * set userId
     *
     * @param userId
     * @author lvzf 2016年8月26日
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * get ygProductId
     *
     * @return
     * @author lvzf 2016年8月26日
     */
    public Long getYgProductId() {
        return ygProductId;
    }

    /**
     * set ygProductId
     *
     * @param ygProductId
     * @author lvzf 2016年8月26日
     */
    public void setYgProductId(Long ygProductId) {
        this.ygProductId = ygProductId;
    }

    /**
     * get buyNum
     *
     * @return
     * @author lvzf 2016年8月26日
     */
    public long getBuyNum() {
        return buyNum;
    }

    /**
     * set buyNum
     *
     * @param buyNum
     * @author lvzf 2016年8月26日
     */
    public void setBuyNum(long buyNum) {
        this.buyNum = buyNum;
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


}
