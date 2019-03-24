package com.team.azusa.yiyuan.model;

/**
 * 大转盘实体
 *
 * @author nibili 2016年5月27日
 */
//@Entity
//@Table(name = "yyg_big_wheel")
//@DynamicInsert
//@DynamicUpdate
public class BigWheelInfoEntity extends BaseEntity {

    /** */
    private static final long serialVersionUID = 7400720745175693815L;

    /**
     * 用户id
     */
//	@Column(nullable = false)
    private Long userId;
    /**
     * 活动标题
     */
//	@Column(nullable = false)
    private String title;
    /**
     * 活动说明
     */
//	@Column(nullable = false)
    private String description;
    /**
     * 附件表id
     */
    private Long photoId;
    /**
     * 照片路径
     */
    private String photoPath;
    /**
     * 活动规则
     */
//	@Column(columnDefinition = "longtext COMMENT '正文'")
    private String activeRule;
    /**
     * 转盘刻度，id集合，以","分隔
     */
    private String wheelCalibrations;

    /**
     * get 活动标题
     *
     * @return
     * @author nibili 2016年6月1日
     */
    public String getTitle() {
        return title;
    }

    /**
     * set 活动标题
     *
     * @param title
     * @author nibili 2016年6月1日
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * get 活动说明
     *
     * @return
     * @author nibili 2016年6月1日
     */
    public String getDescription() {
        return description;
    }

    /**
     * set 活动说明
     *
     * @param description
     * @author nibili 2016年6月1日
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get 附件表id
     *
     * @return
     * @author nibili 2016年6月1日
     */
    public Long getPhotoId() {
        return photoId;
    }

    /**
     * set 附件表id
     *
     * @param photoId
     * @author nibili 2016年6月1日
     */
    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    /**
     * get 照片路径
     *
     * @return
     * @author nibili 2016年6月1日
     */
    public String getPhotoPath() {
        return photoPath;
    }

    /**
     * set 照片路径
     *
     * @param photoPath
     * @author nibili 2016年6月1日
     */
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    /**
     * get 活动规则
     *
     * @return
     * @author nibili 2016年6月1日
     */
    public String getActiveRule() {
        return activeRule;
    }

    /**
     * set 活动规则
     *
     * @param activeRule
     * @author nibili 2016年6月1日
     */
    public void setActiveRule(String activeRule) {
        this.activeRule = activeRule;
    }

    /**
     * get 转盘刻度，id集合，以""分隔
     *
     * @return
     * @author nibili 2016年6月1日
     */
    public String getWheelCalibrations() {
        return wheelCalibrations;
    }

    /**
     * set 转盘刻度，id集合，以""分隔
     *
     * @param wheelCalibrations
     * @author nibili 2016年6月1日
     */
    public void setWheelCalibrations(String wheelCalibrations) {
        this.wheelCalibrations = wheelCalibrations;
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

}
