package com.team.azusa.yiyuan.model;

//import com.google.common.collect.Lists;

//import org.apache.commons.lang3.StringUtils;

//import cn.com.easy.persistence.BaseEntity;
//import cn.com.easy.utils.FastJSONUtils;
//import cn.com.easy.utils.SpringContextHolder;
//import cn.com.yyg.front.utils.BaseConfig;

/**
 * 商品分享晒单表
 *
 * @author lvzf
 */
//@Entity
//@Table(name = "yyg_yg_share")
//@DynamicInsert
//@DynamicUpdate
public class YgShareEntity extends BaseEntity {

    /** */
    private static final long serialVersionUID = 6154299773819985798L;
    /**
     * 商品id
     */
//	@Column(nullable = false)
    private Long productId;
    /**
     * 云购商品id
     */
//	@Column(nullable = false)
    private Long ygProductId;
    //	@Transient
    private YgProductEntity ygProduct;
    /**
     * 当前期数
     */
//	@Column(nullable = false, columnDefinition = " int default 1")
    private long period;
    /**
     * 文章标题
     */
//	@Column(nullable = false)
    private String title;
    /**
     * 晒单内容
     */
//	@Column(columnDefinition = " varchar(3000) ")
    private String content;

    /**
     * 分享的用户id
     */
//	@Column(nullable = false)
    private Long userId;
    /**
     * 用户昵称
     */
    private String userNickName;
    /**
     * 云用户头像
     */
    private String userLogoPath;
    /**
     * 是否审核
     */
    private boolean audit;
    /**
     * 图集
     */
//	@Column(columnDefinition = " varchar(3000) ")
    private String photos;

    /**
     * 图集集合
     */
//	@Transient
//    public List<String> getPhotoList() {
//        List<String> list = new ArrayList<>();
//        if (StringUtils.isNoneBlank(photos)) {
//            list = FastJSONUtils.toArray(photos, String.class);
//        }
//        BaseConfig baseConfig = SpringContextHolder.getBean(BaseConfig.class);
//        int index = 0;
//        for (String p : list) {
//            if (!p.startsWith("http://")) {
//                p = baseConfig.getImgServerUrl() + p;
//                list.set(index, p);
//            }
//            index++;
//        }
//        return list;
//    }

    /**
     * 推荐
     */
//	@Column(nullable = false, columnDefinition = " bit default 0 ")
    private boolean recommend;

    /**
     * get productId
     *
     * @return
     * @author lvzf 2016年8月20日
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * set productId
     *
     * @param productId
     * @author lvzf 2016年8月20日
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * get ygProductId
     *
     * @return
     * @author lvzf 2016年8月20日
     */
    public Long getYgProductId() {
        return ygProductId;
    }

    /**
     * set ygProductId
     *
     * @param ygProductId
     * @author lvzf 2016年8月20日
     */
    public void setYgProductId(Long ygProductId) {
        this.ygProductId = ygProductId;
    }

    /**
     * get title
     *
     * @return
     * @author lvzf 2016年8月20日
     */
    public String getTitle() {
        return title;
    }

    /**
     * set title
     *
     * @param title
     * @author lvzf 2016年8月20日
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * get content
     *
     * @return
     * @author lvzf 2016年8月20日
     */
    public String getContent() {
        return content;
    }

    /**
     * set content
     *
     * @param content
     * @author lvzf 2016年8月20日
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * get userId
     *
     * @return
     * @author lvzf 2016年8月20日
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * set userId
     *
     * @param userId
     * @author lvzf 2016年8月20日
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * get audit
     *
     * @return
     * @author lvzf 2016年8月20日
     */
    public boolean isAudit() {
        return audit;
    }

    /**
     * set audit
     *
     * @param audit
     * @author lvzf 2016年8月20日
     */
    public void setAudit(boolean audit) {
        this.audit = audit;
    }

    /**
     * get photos
     *
     * @return
     * @author lvzf 2016年8月20日
     */
    public String getPhotos() {
        return photos;
    }

    /**
     * set photos
     *
     * @param photos
     * @author lvzf 2016年8月20日
     */
    public void setPhotos(String photos) {
        this.photos = photos;
    }

    /**
     * get recommend
     *
     * @return
     * @author lvzf 2016年8月20日
     */
    public boolean isRecommend() {
        return recommend;
    }

    /**
     * set recommend
     *
     * @param recommend
     * @author lvzf 2016年8月20日
     */
    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    /**
     * get period
     *
     * @return
     * @author lvzf 2016年9月5日
     */
    public long getPeriod() {
        return period;
    }

    /**
     * set period
     *
     * @param period
     * @author lvzf 2016年9月5日
     */
    public void setPeriod(long period) {
        this.period = period;
    }

    /**
     * get userNickName
     *
     * @return
     * @author lvzf 2016年9月5日
     */
    public String getUserNickName() {
        return userNickName;
    }

    /**
     * set userNickName
     *
     * @param userNickName
     * @author lvzf 2016年9月5日
     */
    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    /**
     * get userLogoPath
     *
     * @return
     * @author lvzf 2016年9月5日
     */
    public String getUserLogoPath() {
        return userLogoPath;
    }

    /**
     * set userLogoPath
     *
     * @param userLogoPath
     * @author lvzf 2016年9月5日
     */
    public void setUserLogoPath(String userLogoPath) {
        this.userLogoPath = userLogoPath;
    }

    /**
     * get ygProduct
     *
     * @return
     * @author lvzf 2016年9月18日
     */
    public YgProductEntity getYgProduct() {
        return ygProduct;
    }

    /**
     * set ygProduct
     *
     * @param ygProduct
     * @author lvzf 2016年9月18日
     */
    public void setYgProduct(YgProductEntity ygProduct) {
        this.ygProduct = ygProduct;
    }

}
