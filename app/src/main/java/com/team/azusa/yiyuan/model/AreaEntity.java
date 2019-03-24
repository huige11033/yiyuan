package com.team.azusa.yiyuan.model;

import java.io.Serializable;

/**
 * 地域编码表
 *
 * @author linwk 2016年8月10日
 */
//@Entity
//@Table(name = "yyg_area")
//@DynamicInsert
//@DynamicUpdate
public class AreaEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1202295682186650999L;
    /**
     * 地域名称
     */
    private String areaName;
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
     * get areaName
     *
     * @return
     * @author linwk 2016年8月10日
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * set areaName
     *
     * @param areaName
     * @author linwk 2016年8月10日
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * get parentId
     *
     * @return
     * @author linwk 2016年8月10日
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * set parentId
     *
     * @param parentId
     * @author linwk 2016年8月10日
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * get seqNo
     *
     * @return
     * @author linwk 2016年8月10日
     */
    public int getSeqNo() {
        return seqNo;
    }

    /**
     * set seqNo
     *
     * @param seqNo
     * @author linwk 2016年8月10日
     */
    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    /**
     * get level
     *
     * @return
     * @author linwk 2016年8月10日
     */
    public int getLevel() {
        return level;
    }

    /**
     * set level
     *
     * @param level
     * @author linwk 2016年8月10日
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * get common
     *
     * @return
     * @author linwk 2016年8月10日
     */
    public boolean isCommon() {
        return common;
    }

    /**
     * set common
     *
     * @param common
     * @author linwk 2016年8月10日
     */
    public void setCommon(boolean common) {
        this.common = common;
    }

}
