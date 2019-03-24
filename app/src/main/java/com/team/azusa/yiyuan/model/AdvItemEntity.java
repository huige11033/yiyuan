package com.team.azusa.yiyuan.model;

//import org.apache.commons.lang3.StringUtils;
//
//import cn.com.easy.persistence.BaseEntity;
//import cn.com.easy.utils.SpringContextHolder;
//import cn.com.yyg.front.utils.BaseConfig;


/**
 * 广告
 */
//@Entity
//@Table(name="ygg_adv_item")
//@DynamicInsert
//@DynamicUpdate
public class AdvItemEntity extends BaseEntity {

    private static final long serialVersionUID = -427936114073783783L;

    /**
     * 首页幻灯片
     */
    public static final long ADV_INDEX_SLIDE = SysDictEntity.ROOT_ADV_HOME_SLIDE;

    /**
     * APP和WAP首页幻灯片
     */
    public static final long ADV_WAP_INDEX_SLIDE = SysDictEntity.ROOT_ADV_HOME_SLIDE_APP;

    /**
     * 广告位 SysDictEntity
     */
    private Long advId;
    /**
     * 广告图片
     */
    private String photoPath;
    /**
     * 标题
     */
    private String title;
    /**
     * 链接
     */
    private String linkUrl;
    /**
     * 备注
     */
    private String remark;

    /**
     * 排序号
     */
//	@Column(nullable = false, columnDefinition = " int default 0 ")
    private int seqNo;

    /**
     * get advId
     *
     * @return
     * @author lvzf 2016年8月20日
     */
    public Long getAdvId() {
        return advId;
    }

    /**
     * set advId
     *
     * @param advId
     * @author lvzf 2016年8月20日
     */
    public void setAdvId(Long advId) {
        this.advId = advId;
    }

    /**
     * get photoPath
     *
     * @return
     * @author lvzf 2016年8月20日
     */
//    public String getPhotoPath() {
//        if (StringUtils.isBlank(photoPath)) {
//            return "";
//        }
//        if (photoPath.startsWith("http")) {
//            return photoPath;
//        }
//        BaseConfig baseConfig = SpringContextHolder.getBean(BaseConfig.class);
//        return baseConfig.getImgServerUrl() + photoPath;
//    }

    /**
     * set photoPath
     *
     * @param photoPath
     * @author lvzf 2016年8月20日
     */
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
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
     * get linkUrl
     *
     * @return
     * @author lvzf 2016年9月19日
     */
    public String getLinkUrl() {
        return linkUrl;
    }

    /**
     * set linkUrl
     *
     * @param linkUrl
     * @author lvzf 2016年9月19日
     */
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    /**
     * get remark
     *
     * @return
     * @author lvzf 2016年8月20日
     */
    public String getRemark() {
        return remark;
    }

    /**
     * set remark
     *
     * @param remark
     * @author lvzf 2016年8月20日
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * get seqNo
     *
     * @return
     * @author lvzf 2016年8月20日
     */
    public int getSeqNo() {
        return seqNo;
    }

    /**
     * get seqNo
     *
     * @return
     * @author lvzf 2016年8月20日
     */
    public int isSeqNo() {
        return seqNo;
    }

    /**
     * set seqNo
     *
     * @param seqNo
     * @author lvzf 2016年8月20日
     */
    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }


}