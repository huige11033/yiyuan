package com.team.azusa.yiyuan.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 用户资金账户明细
 *
 * @author lvzf    2016年10月26日
 */
//@Entity
//@Table(name = "yyg_user_account_detail")
//@DynamicInsert
//@DynamicUpdate
public class UserAccountDetailEntity extends BaseEntity implements Serializable {
    /** */
    private static final long serialVersionUID = 6932550202861529704L;
    /**
     * 用户
     */
//	@Column(nullable = false)
    private Long userId;
    /**
     * 余额
     */
//	@Column(nullable = false, columnDefinition = "decimal default 0 ")
    private BigDecimal amount;
    /**
     * +-
     */
    private String direction;
    private String remark;

    /**
     * get userId
     *
     * @return
     * @author lvzf 2016年10月26日
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * set userId
     *
     * @param userId
     * @author lvzf 2016年10月26日
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * get amount
     *
     * @return
     * @author lvzf 2016年10月26日
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * set amount
     *
     * @param amount
     * @author lvzf 2016年10月26日
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * get direction
     *
     * @return
     * @author lvzf 2016年10月26日
     */
    public String getDirection() {
        return direction;
    }

    /**
     * set direction
     *
     * @param direction
     * @author lvzf 2016年10月26日
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * get remark
     *
     * @return
     * @author lvzf 2016年10月26日
     */
    public String getRemark() {
        return remark;
    }

    /**
     * set remark
     *
     * @param remark
     * @author lvzf 2016年10月26日
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

}
