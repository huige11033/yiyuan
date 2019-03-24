package com.team.azusa.yiyuan.model;

/**
 * 系统通知公告
 *
 * @author lvzf
 */
//@Entity
//@Table(name = "yyg_sys_notice")
//@DynamicInsert
//@DynamicUpdate
public class SysNoticeEntity extends BaseEntity {


    /**
     *
     */
    private static final long serialVersionUID = 8020124773031045380L;

    /**
     * 分类：activity-活动公告，system-系统公告，features-功能推荐
     */
//	@Column(nullable = false)
    private String category;

    /**
     * 标题
     */
//	@Column(nullable = false)
    private String title;
    /**
     * 摘要
     */
//	@Column(length=512)
    private String summary;

    /**
     * 保存到内容表yyg_content
     */
//	@Transient
    private ContentEntity content;

    /**
     * 封面图
     */
    private Long coverPhotoId;
    /**
     * 外链
     */
    private String linkUrl;
    /**
     * 是否发布
     */
    private Boolean publish;
    /**
     * 是否置顶
     */
    private Boolean top;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public ContentEntity getContent() {
        return content;
    }

    public void setContent(ContentEntity content) {
        this.content = content;
    }

    public Long getCoverPhotoId() {
        return coverPhotoId;
    }

    public void setCoverPhotoId(Long coverPhotoId) {
        this.coverPhotoId = coverPhotoId;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public Boolean getPublish() {
        return publish;
    }

    public void setPublish(Boolean publish) {
        this.publish = publish;
    }

    public Boolean getTop() {
        return top;
    }

    public void setTop(Boolean top) {
        this.top = top;
    }


}
