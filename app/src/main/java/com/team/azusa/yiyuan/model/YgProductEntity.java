package com.team.azusa.yiyuan.model;

import java.util.Date;

//import cn.com.easy.persistence.BaseEntity;
//import cn.com.easy.utils.SpringContextHolder;
//import cn.com.yyg.base.eum.YgProductStatusEnum;
//import cn.com.yyg.front.utils.BaseConfig;

/**
 * 云购商品表
 *
 * @author lvzf    2016年8月19日
 */
//@Entity
//@Table(name = "yyg_yg_product")
//@DynamicInsert
//@DynamicUpdate
public class YgProductEntity extends BaseEntity {
    /** */
    private static final long serialVersionUID = -7293988646819308993L;
    /**
     * 初始购买号码
     */
    public final static long INIT_BUY_NO = 10000000;
    /**
     * 最大总份数
     */
    public final static long MAX_BUY_NUM = 99999999;
    /**
     * 商品id
     */
    private Long productId;
    /**
     * 上一期云购商品id
     */
    private Long preYgProductId;
    /**
     * 商品名称
     */
//	@Column(nullable = false,columnDefinition = "varchar(500) COMMENT '商品名称'")
    private String name;
    /**
     * 商品副标题
     */
//	@Column(columnDefinition = "varchar(500) COMMENT '商品副标题'")
    private String title;
    /**
     * 封面图路径
     */
    private String logoPath;
    /**
     * 所属品牌
     */
    private Long brandId;
    /**
     * 所属分类
     */
    private String cateId;
    /**
     * 原价格
     */
//	@Column(nullable = false, columnDefinition = " bigint default 0 ")
    private long origPrice;
    /**
     * 单次购买价格
     */
//	@Column(nullable = false, columnDefinition = " bigint default 0 ")
    private long singlePrice;
    /**
     * 总份数（总人次）
     */
//	@Column(nullable = false, columnDefinition = " bigint default 0 ")
    private long totalNum;
    /**剩余云购号码：1-totalNum之间*/
//	@Column(columnDefinition = "longtext COMMENT '剩余云购号码：1-totalNum之间'")
    /**
     * 保存到内容表 ContentEntity
     */
    private Long leaveBuyNosContentId;


    /**
     * 参与份数（总人次）
     */
//	@Column(nullable = false, columnDefinition = " bigint default 0 ")
    private long usedNum;
    /**
     * 剩余份数（总人次）
     */
//	@Column(nullable = false, columnDefinition = " bigint default 0 ")
    private long leaveNum;
    /**
     * 最大期数
     */
//	@Column(nullable = false, columnDefinition = " bigint default 100")
    private Long limitPeriods;
    /**
     * 当前期数
     */
//	@Column(nullable = false, columnDefinition = " int default 1")
    private long period;
    /**
     * 状态：0-进行中，1-即将揭晓，2-开奖计算中,3-已揭晓,4-删除
     */
//	@Column(nullable = false, columnDefinition = " int default 0")
    private int status;

    public String getStatusName() {
        switch (status) {
            case 0:return "进行中";
            case 1:return "即将揭晓";
            case 2:return "开奖计算中";
            case 3:return "已揭晓";
            case 4:return "删除";
        }
        return "";
    }

    /**
     * 推荐
     */
//	@Column(nullable = false, columnDefinition = " bit default 0 ")
    private boolean recommend;
    /**
     * 排序号（人气）
     */
//	@Column(nullable = false, columnDefinition = " bigint default 0")
    private int seqNo;
    /**
     * 揭晓时间
     */
    private Long publishDate;

    /**
     * 揭晓时间长
     */
//    public Long getPublishDateLong() {
//        if (publishDate != null) {
//            return publishDate.getTime() - System.currentTimeMillis();
//        }
//        return 0L;
//    }

    /**
     * 老老时彩号码
     */
//	@Column( columnDefinition = " bit default 0 ")
    private Long llscNo;

    /**
     * 老老时彩期号
     */
    private Long llscPeriodNo;

    /**
     * 指定中奖号
     */
//	@Column(nullable = false, columnDefinition = " bit default 0 ")
    private boolean zdWin;
    /**
     * 中奖号码
     */
    private Long winNo;
    /**
     * 中奖用户id
     */
    private Long winUserId;
    /**
     * 中奖用户昵称
     */
    private String winUserNickName;
    /**
     * 中奖用户头像
     */
    private String winUserLogoPath;
    /**
     * 中奖用户本期参与份数
     */
//	@Column(columnDefinition = " bigint default 0 ")
    private Long winUserBuyNum;

    /**
     * 中奖用户ip地址
     */
    private String winUserIpAddr;
    /**
     * 中奖时间
     */
    private Long winDate;
    /**
     * 购买（夺宝）时间
     */
//	@Column(columnDefinition = "bigint default 0 COMMENT '购买时间'")
    private Long winUserBuyDateLong;

    /**
     * 购买（夺宝）时间
     */
    public Date getWinUserBuyDate() {
        if (winUserBuyDateLong == null) {
            return null;
        }
        return new Date(winUserBuyDateLong);
    }

    /**
     * 最后一个用户购买（夺宝）时间
     */
//	@Column(columnDefinition = "bigint COMMENT '最后一个用户购买时间'")
    private Long lastUserBuyDateLong;

    /**
     * 最后一个用户购买（夺宝）时间
     */
    public Date getLastUserBuyDate() {
        if (lastUserBuyDateLong == null) {
            return null;
        }
        return new Date(lastUserBuyDateLong);
    }

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
     * get name
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public String getName() {
        return name;
    }

    /**
     * set name
     *
     * @param name
     * @author lvzf 2016年8月27日
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get title
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public String getTitle() {
        return title;
    }

    /**
     * set title
     *
     * @param title
     * @author lvzf 2016年8月27日
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * get logoPath
     *
     * @return
     * @author lvzf 2016年8月27日
     */
//    public String getLogoPath() {
//        if (logoPath != null && logoPath.startsWith("http")) {
//            return logoPath;
//        }
//        BaseConfig baseConfig = SpringContextHolder.getBean(BaseConfig.class);
//        return baseConfig.getImgServerUrl() + logoPath;
//    }

    /**
     * set logoPath
     *
     * @param logoPath
     * @author lvzf 2016年8月27日
     */
    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    /**
     * get brandId
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public Long getBrandId() {
        return brandId;
    }

    /**
     * set brandId
     *
     * @param brandId
     * @author lvzf 2016年8月27日
     */
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    /**
     * get cateId
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public String getCateId() {
        return cateId;
    }

    /**
     * set cateId
     *
     * @param cateId
     * @author lvzf 2016年8月27日
     */
    public void setCateId(String cateId) {
        this.cateId = cateId;
    }

    /**
     * get origPrice
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public long getOrigPrice() {
        return origPrice;
    }

    /**
     * set origPrice
     *
     * @param origPrice
     * @author lvzf 2016年8月27日
     */
    public void setOrigPrice(long origPrice) {
        this.origPrice = origPrice;
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
     * get usedNum
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public long getUsedNum() {
        return usedNum;
    }

    /**
     * set usedNum
     *
     * @param usedNum
     * @author lvzf 2016年8月27日
     */
    public void setUsedNum(long usedNum) {
        this.usedNum = usedNum;
    }

    /**
     * get leaveNum
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public long getLeaveNum() {
        return leaveNum;
    }

    /**
     * set leaveNum
     *
     * @param leaveNum
     * @author lvzf 2016年8月27日
     */
    public void setLeaveNum(long leaveNum) {
        this.leaveNum = leaveNum;
    }

    /**
     * get limitPeriods
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public Long getLimitPeriods() {
        return limitPeriods;
    }

    /**
     * set limitPeriods
     *
     * @param limitPeriods
     * @author lvzf 2016年8月27日
     */
    public void setLimitPeriods(Long limitPeriods) {
        this.limitPeriods = limitPeriods;
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
     * get recommend
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public boolean isRecommend() {
        return recommend;
    }

    /**
     * set recommend
     *
     * @param recommend
     * @author lvzf 2016年8月27日
     */
    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    /**
     * get publishDate
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public Long getPublishDate() {
        return publishDate;
    }

    /**
     * set publishDate
     *
     * @param publishDate
     * @author lvzf 2016年8月27日
     */
    public void setPublishDate(Long publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * get llscNo
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public Long getLlscNo() {
        return llscNo;
    }

    /**
     * set llscNo
     *
     * @param llscNo
     * @author lvzf 2016年8月27日
     */
    public void setLlscNo(Long llscNo) {
        this.llscNo = llscNo;
    }

    /**
     * get llscPeriodNo
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public Long getLlscPeriodNo() {
        return llscPeriodNo;
    }

    /**
     * set llscPeriodNo
     *
     * @param llscPeriodNo
     * @author lvzf 2016年8月27日
     */
    public void setLlscPeriodNo(Long llscPeriodNo) {
        this.llscPeriodNo = llscPeriodNo;
    }

    /**
     * get zdWin
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public boolean isZdWin() {
        return zdWin;
    }

    /**
     * set zdWin
     *
     * @param zdWin
     * @author lvzf 2016年8月27日
     */
    public void setZdWin(boolean zdWin) {
        this.zdWin = zdWin;
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
     * get winUserId
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public Long getWinUserId() {
        return winUserId;
    }

    /**
     * set winUserId
     *
     * @param winUserId
     * @author lvzf 2016年8月27日
     */
    public void setWinUserId(Long winUserId) {
        this.winUserId = winUserId;
    }

    /**
     * get winUserNickName
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public String getWinUserNickName() {
        return winUserNickName;
    }

    /**
     * set winUserNickName
     *
     * @param winUserNickName
     * @author lvzf 2016年8月27日
     */
    public void setWinUserNickName(String winUserNickName) {
        this.winUserNickName = winUserNickName;
    }

    /**
     * get winUserBuyNum
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public Long getWinUserBuyNum() {
        return winUserBuyNum;
    }

    /**
     * set winUserBuyNum
     *
     * @param winUserBuyNum
     * @author lvzf 2016年8月27日
     */
    public void setWinUserBuyNum(Long winUserBuyNum) {
        this.winUserBuyNum = winUserBuyNum;
    }

    /**
     * get winDate
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public Long getWinDate() {
        return winDate;
    }

    /**
     * set winDate
     *
     * @param winDate
     * @author lvzf 2016年8月27日
     */
    public void setWinDate(Long winDate) {
        this.winDate = winDate;
    }

    /**
     * get winUserBuyDateLong
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public Long getWinUserBuyDateLong() {
        return winUserBuyDateLong;
    }

    /**
     * set winUserBuyDateLong
     *
     * @param winUserBuyDateLong
     * @author lvzf 2016年8月27日
     */
    public void setWinUserBuyDateLong(Long winUserBuyDateLong) {
        this.winUserBuyDateLong = winUserBuyDateLong;
    }

    /**
     * get lastUserBuyDateLong
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public Long getLastUserBuyDateLong() {
        return lastUserBuyDateLong;
    }

    /**
     * set lastUserBuyDateLong
     *
     * @param lastUserBuyDateLong
     * @author lvzf 2016年8月27日
     */
    public void setLastUserBuyDateLong(Long lastUserBuyDateLong) {
        this.lastUserBuyDateLong = lastUserBuyDateLong;
    }

    /**
     * get leaveBuyNosContentId
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public Long getLeaveBuyNosContentId() {
        return leaveBuyNosContentId;
    }

    /**
     * set leaveBuyNosContentId
     *
     * @param leaveBuyNosContentId
     * @author lvzf 2016年8月27日
     */
    public void setLeaveBuyNosContentId(Long leaveBuyNosContentId) {
        this.leaveBuyNosContentId = leaveBuyNosContentId;
    }

    /**
     * get winUserLogoPath
     *
     * @return
     * @author lvzf 2016年8月29日
     */
    public String getWinUserLogoPath() {
        return winUserLogoPath;
    }

    /**
     * set winUserLogoPath
     *
     * @param winUserLogoPath
     * @author lvzf 2016年8月29日
     */
    public void setWinUserLogoPath(String winUserLogoPath) {
        this.winUserLogoPath = winUserLogoPath;
    }

    /**
     * get seqNo
     *
     * @return
     * @author lvzf 2016年8月30日
     */
    public int getSeqNo() {
        return seqNo;
    }

    /**
     * set seqNo
     *
     * @param seqNo
     * @author lvzf 2016年8月30日
     */
    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    /**
     * get preYgProductId
     *
     * @return
     * @author lvzf 2016年9月5日
     */
    public Long getPreYgProductId() {
        return preYgProductId;
    }

    /**
     * set preYgProductId
     *
     * @param preYgProductId
     * @author lvzf 2016年9月5日
     */
    public void setPreYgProductId(Long preYgProductId) {
        this.preYgProductId = preYgProductId;
    }

    /**
     * get winUserIpAddr
     *
     * @return
     * @author lvzf 2016年10月20日
     */
    public String getWinUserIpAddr() {
        return winUserIpAddr;
    }

    /**
     * set winUserIpAddr
     *
     * @param winUserIpAddr
     * @author lvzf 2016年10月20日
     */
    public void setWinUserIpAddr(String winUserIpAddr) {
        this.winUserIpAddr = winUserIpAddr;
    }

    public String getLogoPath() {
        return logoPath;
    }
}
