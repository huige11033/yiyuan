package com.team.azusa.yiyuan.model;

//import com.google.common.collect.Lists;
//
//import org.apache.commons.lang3.StringUtils;

//import cn.com.easy.persistence.BaseEntity;
//import cn.com.easy.utils.FastJSONUtils;
//import cn.com.easy.utils.SpringContextHolder;
//import cn.com.yyg.front.dto.ProductPhotoDto;
//import cn.com.yyg.front.utils.BaseConfig;

//import cn.com.yyg.front.dto.ProductPhotoDto;

/**
 * 商品表
 *
 * @author lvzf 2016年8月19日
 */
//@Entity
//@Table(name = "yyg_product")
//@DynamicInsert
//@DynamicUpdate
public class ProductEntity extends BaseEntity {
    /** */
    private static final long serialVersionUID = 5000581615498043411L;
    /**
     * 上架
     */
    public static final int STATUS_UP = 1;
    /**
     * 下架
     */
    public static final int STATUS_DOWN = 0;

    /**
     * 商品名称
     */
//	@Column(nullable = false, columnDefinition = "varchar(500) COMMENT '商品名称'")
    private String name;
    /**
     * 商品副标题
     */
//	@Column(columnDefinition = "varchar(500) COMMENT '商品副标题'")
    private String title;
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
    /**
     * 最大期数
     */
    private Long limitPeriods = 500L;
    /**
     * 当前期数
     */
//	@Column(nullable = false, columnDefinition = " bigint default 0 ")
    private long period = 0;
    /**
     * 状态：0-上架，1-下架
     */
    private int status;
    /**
     * 封面图路径
     */
    private String logoPath;
    /**
     * 商品图集
     */
//	@Column(columnDefinition = " varchar(3000) ")
    private String photos;

//    public List<ProductPhotoDto> getPhotoList() {
//        if (StringUtils.isNoneBlank(photos)) {
//            return FastJSONUtils.toArray(photos, ProductPhotoDto.class);
//        }
//        return Lists.newArrayList();
//    }

    /**
     * 保存到内容表 ContentEntity
     */
    private Long contentId;
    /**
     * 内容
     */
//	@Transient
    private String content;

    private String seoTitle;
    private String seoKey;
    private String seoDesc;

    public String getStatusName() {
        if (status == 1) {
            return "上架";
        } else if (status == 0) {
            return "下架";
        }
        return "";
    }

    /**
     * 所属品牌
     */
    private Long brandId;
    /**
     * 所属分类 productType表
     */
    private String cateId;

    /**
     * 推荐
     */
//	@Column(nullable = false, columnDefinition = " bit default 0 ")
    private boolean recommend;
    /**
     * 排序号（人气）
     */
//	@Column(nullable = false, columnDefinition = " bigint default 50 ")
    private int seqNo;


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
     * get photos
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public String getPhotos() {
        return photos;
    }


    /**
     * set photos
     *
     * @param photos
     * @author lvzf 2016年8月27日
     */
    public void setPhotos(String photos) {
        this.photos = photos;
    }


    /**
     * get contentId
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public Long getContentId() {
        return contentId;
    }


    /**
     * set contentId
     *
     * @param contentId
     * @author lvzf 2016年8月27日
     */
    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }


    /**
     * get content
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public String getContent() {
        return content;
    }


    /**
     * set content
     *
     * @param content
     * @author lvzf 2016年8月27日
     */
    public void setContent(String content) {
        this.content = content;
    }


    /**
     * get seoTitle
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public String getSeoTitle() {
        return seoTitle;
    }


    /**
     * set seoTitle
     *
     * @param seoTitle
     * @author lvzf 2016年8月27日
     */
    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }


    /**
     * get seoKey
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public String getSeoKey() {
        return seoKey;
    }


    /**
     * set seoKey
     *
     * @param seoKey
     * @author lvzf 2016年8月27日
     */
    public void setSeoKey(String seoKey) {
        this.seoKey = seoKey;
    }


    /**
     * get seoDesc
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public String getSeoDesc() {
        return seoDesc;
    }


    /**
     * set seoDesc
     *
     * @param seoDesc
     * @author lvzf 2016年8月27日
     */
    public void setSeoDesc(String seoDesc) {
        this.seoDesc = seoDesc;
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
     * get seqNo
     *
     * @return
     * @author lvzf 2016年8月27日
     */
    public int getSeqNo() {
        return seqNo;
    }


    /**
     * set seqNo
     *
     * @param seqNo
     * @author lvzf 2016年8月27日
     */
    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }


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
     * get logoPath
     *
     * @return
     * @author lvzf 2016年8月19日
     */
//    public String getLogoPath() {
//        if (StringUtils.isBlank(logoPath)) {
//            return null;
//        }
//        if (logoPath.startsWith("http")) {
//            return logoPath;
//        }
//        BaseConfig baseConfig = SpringContextHolder.getBean(BaseConfig.class);
//        return baseConfig.getImgServerUrl() + logoPath;
//    }


}
