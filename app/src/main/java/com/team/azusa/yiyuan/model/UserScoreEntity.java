package com.team.azusa.yiyuan.model;

//import cn.com.easy.persistence.BaseEntity;
//import cn.com.yyg.base.eum.UserScoreTypeEnum;

/**
 * 用户积分明细表
 *
 * @author lvzf 2016年10月12日
 */
//@Entity
//@Table(name = "yyg_yg_user_score")
//@DynamicInsert
//@DynamicUpdate
public class UserScoreEntity extends BaseEntity {
    /** */
    private static final long serialVersionUID = 6683928963858009950L;
    private Long userId;
    /**
     * 积分
     */
    private int score;
    /**
     * +-
     */
    private String direction;
    /**
     * 积分类型
     */
    private int scoreType;
    /**
     * 日期
     */
    private String yyyymmdd;

//    public String getScoreTypeName() {
//        return UserScoreTypeEnum.getName(scoreType);
//    }

    /**
     * 备注
     */
    private String remark;

    /**
     * get userId
     *
     * @return
     * @author lvzf 2016年10月12日
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * set userId
     *
     * @param userId
     * @author lvzf 2016年10月12日
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * get score
     *
     * @return
     * @author lvzf 2016年10月12日
     */
    public int getScore() {
        return score;
    }

    /**
     * set score
     *
     * @param score
     * @author lvzf 2016年10月12日
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * get direction
     *
     * @return
     * @author lvzf 2016年10月12日
     */
    public String getDirection() {
        return direction;
    }

    /**
     * set direction
     *
     * @param direction
     * @author lvzf 2016年10月12日
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }


    /**
     * get scoreType
     *
     * @return
     * @author lvzf 2016年10月12日
     */
    public int getScoreType() {
        return scoreType;
    }

    /**
     * set scoreType
     *
     * @param scoreType
     * @author lvzf 2016年10月12日
     */
    public void setScoreType(int scoreType) {
        this.scoreType = scoreType;
    }

    /**
     * get remark
     *
     * @return
     * @author lvzf 2016年10月12日
     */
    public String getRemark() {
        return remark;
    }

    /**
     * set remark
     *
     * @param remark
     * @author lvzf 2016年10月12日
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * get yyyymmdd
     *
     * @return
     * @author lvzf 2016年10月14日
     */
    public String getYyyymmdd() {
        return yyyymmdd;
    }

    /**
     * set yyyymmdd
     *
     * @param yyyymmdd
     * @author lvzf 2016年10月14日
     */
    public void setYyyymmdd(String yyyymmdd) {
        this.yyyymmdd = yyyymmdd;
    }

//    @Override
//    public String toString() {
//        return "UserScoreEntity [userId=" + userId + ", score=" + score + ", direction=" + direction + ", scoreType=" + scoreType + ", yyyymmdd=" + yyyymmdd + ", remark=" + remark + "]";
//    }
}
