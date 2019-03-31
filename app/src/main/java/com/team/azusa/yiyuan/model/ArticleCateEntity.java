package com.team.azusa.yiyuan.model;

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
     * id : 2
     * version : 0
     * createBy : null
     * createById : null
     * lastModifyById : 1
     * name : 新手指南
     * parentId : 1
     * seqNo : 1
     * remark :
     * pinyin : null
     * children : null
     * articles : null
     */

    public int idX;
    public int version;
    public Object createBy;
    public Object createById;
    public int lastModifyById;
    public String name;
    public int parentId;
    public int seqNo;
    public String remark;
    public Object pinyin;
    public Object children;
    public Object articles;
}
