package com.team.azusa.yiyuan.model;

import java.io.Serializable;

/**
 * 品牌表
 *
 * @author linwk 2016年8月26日
 */
//@Entity
//@Table(name = "yyg_brand")
//@DynamicInsert
//@DynamicUpdate
public class BrandEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1202295682186650999L;
    /**
     * 品牌名称
     */
    private String brandName;
    //	@Column(name = "parent_id")
    private Long parentId;
    //	@Column(name = "sequence")
    private int seqNo;
    /**
     * 层级
     */
    private int level;

    //	@Column(columnDefinition = "bit default false")
    private boolean common;

    /**
     * 字体图片
     */
    private String iconFrontCode;


    /**
     * get parentId
     *
     * @return
     * @author linwk 2016年8月26日
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * set parentId
     *
     * @param parentId
     * @author linwk 2016年8月26日
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * get seqNo
     *
     * @return
     * @author linwk 2016年8月26日
     */
    public int getSeqNo() {
        return seqNo;
    }

    /**
     * set seqNo
     *
     * @param seqNo
     * @author linwk 2016年8月26日
     */
    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    /**
     * get level
     *
     * @return
     * @author linwk 2016年8月26日
     */
    public int getLevel() {
        return level;
    }

    /**
     * set level
     *
     * @param level
     * @author linwk 2016年8月26日
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * get common
     *
     * @return
     * @author linwk 2016年8月26日
     */
    public boolean isCommon() {
        return common;
    }

    /**
     * set common
     *
     * @param common
     * @author linwk 2016年8月26日
     */
    public void setCommon(boolean common) {
        this.common = common;
    }

    /**
     * get brandName
     *
     * @return
     * @author linwk 2016年8月26日
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * set brandName
     *
     * @param brandName
     * @author linwk 2016年8月26日
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * get iconFrontCode
     *
     * @return
     * @author linwk 2016年8月27日
     */
    public String getIconFrontCode() {
        return iconFrontCode;
    }

    /**
     * set iconFrontCode
     *
     * @param iconFrontCode
     * @author linwk 2016年8月27日
     */
    public void setIconFrontCode(String iconFrontCode) {
        this.iconFrontCode = iconFrontCode;
    }

}
