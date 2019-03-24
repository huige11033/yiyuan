package com.team.azusa.yiyuan.model;

import java.util.List;

/**
 * 文章分类
 *
 * @author lvzf
 */
//@Entity
//@Table(name = "yyg_articles_cate")
//@DynamicInsert
//@DynamicUpdate
public class ArticleCateEntity extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = -302208083181241238L;

    /**
     * 分类名称
     */
//	@Column(columnDefinition = "varchar(255) COMMENT '分类名称'", nullable = false)
    private String name;
    /**
     * 父节点id
     */
    private Long parentId;
    /**
     * 排序
     */
//	@Column(nullable = false)
    private int seqNo;
    /**
     * 备注
     */
//	@Column(length = 512)
    private String remark;
    /**
     * 拼音
     */
    private String pinyin;
    /**
     * 子节点
     */
//	@Transient
    private List<ArticleCateEntity> children;


    /**
     * 文章列表
     */
//	@Transient
    private List<ArticleEntity> articles;

    /**
     * 获取 子节点
     *
     * @return
     * @auth nibili 2016年6月9日 下午8:20:41
     */
    public List<ArticleCateEntity> getChildren() {
        return children;
    }

    /**
     * 设置 子节点
     *
     * @param children
     * @auth nibili 2016年6月9日 下午8:20:41
     */
    public void setChildren(List<ArticleCateEntity> children) {
        this.children = children;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
     * get articles
     *
     * @return
     * @author lvzf 2016年10月18日
     */
    public List<ArticleEntity> getArticles() {
        return articles;
    }

    /**
     * set articles
     *
     * @param articles
     * @author lvzf 2016年10月18日
     */
    public void setArticles(List<ArticleEntity> articles) {
        this.articles = articles;
    }

}
