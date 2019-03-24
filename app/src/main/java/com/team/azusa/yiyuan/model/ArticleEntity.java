package com.team.azusa.yiyuan.model;

//import org.apache.commons.lang3.StringUtils;
//
//import javax.persistence.Transient;

/**
 * 文章表
 *
 * @author lvzf
 */
//@Entity
//@Table(name = "yyg_articles")
//@DynamicInsert
//@DynamicUpdate
public class ArticleEntity extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = -4906826443557725056L;

    /**
     * 文章分类
     */
//	@Column(nullable = false)
    private Long articleCateId;
    /**
     * 上级分类
     */
    private String parentCateName;
    /**
     * 文章标题
     */
//	@Column(nullable = false)
    private String title;
    /**
     * 文章摘要
     */
//	@Column(length = 512)
    private String summary;
    /**
     * 保存到内容表yyg_content
     */
    private Long contentId;
    /**
     * 内容
     */
//	@Transient
    private String content;


    /**
     * 文章封面图
     */
    private String coverPhotoPath;
    /**
     * 浏览量
     */
//	@Column(nullable = false)
    private int viewNum = 0;

    /**
     * 发布文章的用户id
     */
//	@Column(nullable = false)
    private Long userId;
    /**
     * 外链
     */
    private String linkUrl;
    /**
     * 拼音
     */
    private String pinyin;
    /**
     * 排序
     */
//	@Column(nullable = false)
    private int seqNo = 0;

    /**
     * 文章seo描述(SEO优化)
     */
    private String seoDescription;
    /**
     * 文章seo标题(SEO优化)
     */
    private String seoTitle;
    /**
     * 文章seo关键词(SEO优化)
     */
    private String seoKeyWords;

    /**
     * 获取链接
     *
     * @return
     * @author lvzf 2016年10月17日
     */
//    @Transient
//    public String getLink() {
///*		ArticleCateEntity cate=new ArticleCateEntity();
//		cate.setId(this.getArticleCateId());*/
//        String link = "content/";
//        if (StringUtils.isNoneBlank(pinyin)) {
//            link = pinyin;
//        } else {
//            link += this.getId();
//        }
//        return link + ".html";
//    }
    public Long getArticleCateId() {
        return articleCateId;
    }

    public void setArticleCateId(Long articleCateId) {
        this.articleCateId = articleCateId;
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

    public int getViewNum() {
        return viewNum;
    }

    public void setViewNum(int viewNum) {
        this.viewNum = viewNum;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    /**
     * get contentId
     *
     * @return
     * @author lvzf 2016年6月2日
     */
    public Long getContentId() {
        return contentId;
    }

    /**
     * set contentId
     *
     * @param contentId
     * @author lvzf 2016年6月2日
     */
    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    /**
     * get content
     *
     * @return
     * @author lvzf 2016年6月2日
     */
    public String getContent() {
        return content;
    }

    /**
     * set content
     *
     * @param content
     * @author lvzf 2016年6月2日
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * get coverPhotoPath
     *
     * @return
     * @author lvzf 2016年6月3日
     */
    public String getCoverPhotoPath() {
        return coverPhotoPath;
    }

    /**
     * set coverPhotoPath
     *
     * @param coverPhotoPath
     * @author lvzf 2016年6月3日
     */
    public void setCoverPhotoPath(String coverPhotoPath) {
        this.coverPhotoPath = coverPhotoPath;
    }

    /**
     * get pinyin
     *
     * @return
     * @author lvzf 2016年10月17日
     */
    public String getPinyin() {
        return pinyin;
    }

    /**
     * set pinyin
     *
     * @param pinyin
     * @author lvzf 2016年10月17日
     */
    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    /**
     * get seoDescription
     *
     * @return
     * @author lvzf 2016年10月17日
     */
    public String getSeoDescription() {
        return seoDescription;
    }

    /**
     * set seoDescription
     *
     * @param seoDescription
     * @author lvzf 2016年10月17日
     */
    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription;
    }

    /**
     * get seoTitle
     *
     * @return
     * @author lvzf 2016年10月17日
     */
    public String getSeoTitle() {
        return seoTitle;
    }

    /**
     * set seoTitle
     *
     * @param seoTitle
     * @author lvzf 2016年10月17日
     */
    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }

    /**
     * get seoKeyWords
     *
     * @return
     * @author lvzf 2016年10月17日
     */
    public String getSeoKeyWords() {
        return seoKeyWords;
    }

    /**
     * set seoKeyWords
     *
     * @param seoKeyWords
     * @author lvzf 2016年10月17日
     */
    public void setSeoKeyWords(String seoKeyWords) {
        this.seoKeyWords = seoKeyWords;
    }

    /**
     * get parentCateName
     *
     * @return
     * @author lvzf 2016年10月17日
     */
    public String getParentCateName() {
        return parentCateName;
    }

    /**
     * set parentCateName
     *
     * @param parentCateName
     * @author lvzf 2016年10月17日
     */
    public void setParentCateName(String parentCateName) {
        this.parentCateName = parentCateName;
    }

    /**
     * get seqNo
     *
     * @return
     * @author lvzf 2016年10月18日
     */
    public int getSeqNo() {
        return seqNo;
    }

    /**
     * set seqNo
     *
     * @param seqNo
     * @author lvzf 2016年10月18日
     */
    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }


}
