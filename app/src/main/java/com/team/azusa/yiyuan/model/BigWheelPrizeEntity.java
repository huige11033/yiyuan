package com.team.azusa.yiyuan.model;

/**
 * 大转盘奖品表
 *
 * @author nibili 2016年5月31日
 */
//@Entity
//@Table(name = "yyg_big_wheel_prize")
//@DynamicInsert
//@DynamicUpdate
public class BigWheelPrizeEntity extends BaseEntity {

    /** */
    private static final long serialVersionUID = 5165127224589577421L;

    /**
     * 领奖方式：邮寄
     */
    public final static int ACCEPT_PRIZE_TYPE_MAIL = 0;
    /**
     * 领奖方式：优惠券
     */
    public final static int ACCEPT_PRIZE_TYPE_COUPONS = 1;
    /**
     * 领奖方式：在线领取
     */
    public final static int ACCEPT_PRIZE_TYPE_ONLINE = 2;
    /**
     * 领奖方式：自提
     */
    public final static int ACCEPT_PRIZE_TYPE_TAKESELF = 3;

    /**
     * 用户id
     */
//	@Column(nullable = false)
    private Long userId;
    /**
     * 大转盘表id
     */
//	@Column(nullable = false)
    private Long bigWheelId;
    /**
     * 奖项等级：一共七级
     */
    private int prizeLevel = 1;
    /**
     * 奖项名称
     */
    private String prizeName;
    /**
     * 奖品类型
     */
    private int prizeType;
    /**
     * 奖品内容
     */
    private String prizeContent;
    /**
     * 奖品积分
     */
    private Long prizeScore;
    /**
     * 附件表id
     */
    private Long photoId;
    /**
     * 照片路径
     */
    private String photoPath;
    /**
     * 奖品数量
     */
    private Integer prizeCount = 1;
    /**
     * 中奖概率
     */
    private Integer prizeRate = 1;
    /**
     * 领奖方式
     */
    private int acceptPrizeType = ACCEPT_PRIZE_TYPE_MAIL;
    /**
     * 优惠券，券码
     */
    private String coupons;
    /**
     * 在线领取url
     */
    private String onLineUrl;
    /**
     * 自提点地址
     */
    private String takeSelfAddress;

    /**
     * get 奖项等级：一共七级
     *
     * @return
     * @author nibili 2016年5月31日
     */
    public int getPrizeLevel() {
        return prizeLevel;
    }

    /**
     * set 奖项等级：一共七级
     *
     * @param prizeLevel
     * @author nibili 2016年5月31日
     */
    public void setPrizeLevel(int prizeLevel) {
        this.prizeLevel = prizeLevel;
    }

    public String getPrizeLevelName() {
        if (this.prizeLevel == 1) {
            return "一等奖";
        } else if (this.prizeLevel == 2) {
            return "二等奖";
        } else if (this.prizeLevel == 3) {
            return "三等奖";
        } else if (this.prizeLevel == 4) {
            return "四等奖";
        } else if (this.prizeLevel == 5) {
            return "五等奖";
        } else if (this.prizeLevel == 6) {
            return "六等奖";
        } else if (this.prizeLevel == 7) {
            return "七等奖";
        }
        return "鼓励奖";
    }

    /**
     * get 奖项名称
     *
     * @return
     * @author nibili 2016年5月31日
     */
    public String getPrizeName() {
        return prizeName;
    }

    /**
     * set 奖项名称
     *
     * @param prizeName
     * @author nibili 2016年5月31日
     */
    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    /**
     * get 奖品内容
     *
     * @return
     * @author nibili 2016年5月31日
     */
    public String getPrizeContent() {
        return prizeContent;
    }

    /**
     * set 奖品内容
     *
     * @param prizeContent
     * @author nibili 2016年5月31日
     */
    public void setPrizeContent(String prizeContent) {
        this.prizeContent = prizeContent;
    }

    /**
     * get 附件表id
     *
     * @return
     * @author nibili 2016年5月31日
     */
    public Long getPhotoId() {
        return photoId;
    }

    /**
     * set 附件表id
     *
     * @param photoId
     * @author nibili 2016年5月31日
     */
    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    /**
     * get 照片路径
     *
     * @return
     * @author nibili 2016年5月31日
     */
    public String getPhotoPath() {
        return photoPath;
    }

    /**
     * set 照片路径
     *
     * @param photoPath
     * @author nibili 2016年5月31日
     */
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    /**
     * get 领奖方式
     *
     * @return
     * @author nibili 2016年5月31日
     */
    public int getAcceptPrizeType() {
        return acceptPrizeType;
    }

    /**
     * set 领奖方式
     *
     * @param acceptPrizeType
     * @author nibili 2016年5月31日
     */
    public void setAcceptPrizeType(int acceptPrizeType) {
        this.acceptPrizeType = acceptPrizeType;
    }

    /**
     * get 优惠券，券码
     *
     * @return
     * @author nibili 2016年5月31日
     */
    public String getCoupons() {
        return coupons;
    }

    /**
     * set 优惠券，券码
     *
     * @param coupons
     * @author nibili 2016年5月31日
     */
    public void setCoupons(String coupons) {
        this.coupons = coupons;
    }

    /**
     * get 在线领取url
     *
     * @return
     * @author nibili 2016年5月31日
     */
    public String getOnLineUrl() {
        return onLineUrl;
    }

    /**
     * set 在线领取url
     *
     * @param onLineUrl
     * @author nibili 2016年5月31日
     */
    public void setOnLineUrl(String onLineUrl) {
        this.onLineUrl = onLineUrl;
    }

    /**
     * get 自提点地址
     *
     * @return
     * @author nibili 2016年5月31日
     */
    public String getTakeSelfAddress() {
        return takeSelfAddress;
    }

    /**
     * set 自提点地址
     *
     * @param takeSelfAddress
     * @author nibili 2016年5月31日
     */
    public void setTakeSelfAddress(String takeSelfAddress) {
        this.takeSelfAddress = takeSelfAddress;
    }

    /**
     * get 奖品数量
     *
     * @return
     * @author nibili 2016年6月2日
     */
    public Integer getPrizeCount() {
        return prizeCount;
    }

    /**
     * set 奖品数量
     *
     * @param prizeCount
     * @author nibili 2016年6月2日
     */
    public void setPrizeCount(Integer prizeCount) {
        this.prizeCount = prizeCount;
    }

    /**
     * get 中奖概率
     *
     * @return
     * @author nibili 2016年6月2日
     */
    public Integer getPrizeRate() {
        return prizeRate;
    }

    /**
     * set 中奖概率
     *
     * @param prizeRate
     * @author nibili 2016年6月2日
     */
    public void setPrizeRate(Integer prizeRate) {
        this.prizeRate = prizeRate;
    }

    /**
     * get 用户id
     *
     * @return
     * @author nibili 2016年6月2日
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * set 用户id
     *
     * @param userId
     * @author nibili 2016年6月2日
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * get 大转盘表id
     *
     * @return
     * @author nibili 2016年6月2日
     */
    public Long getBigWheelId() {
        return bigWheelId;
    }

    /**
     * set 大转盘表id
     *
     * @param bigWheelId
     * @author nibili 2016年6月2日
     */
    public void setBigWheelId(Long bigWheelId) {
        this.bigWheelId = bigWheelId;
    }

    /**
     * get prizeType
     *
     * @return
     * @author linwk 2016年10月17日
     */
    public int getPrizeType() {
        return prizeType;
    }

    /**
     * set prizeType
     *
     * @param prizeType
     * @author linwk 2016年10月17日
     */
    public void setPrizeType(int prizeType) {
        this.prizeType = prizeType;
    }

    /**
     * get prizeScore
     *
     * @return
     * @author linwk 2016年10月17日
     */
    public Long getPrizeScore() {
        return prizeScore;
    }

    /**
     * set prizeScore
     *
     * @param prizeScore
     * @author linwk 2016年10月17日
     */
    public void setPrizeScore(Long prizeScore) {
        this.prizeScore = prizeScore;
    }

}
