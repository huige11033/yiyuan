package com.team.azusa.yiyuan.model;

import java.util.List;

/**
 * 字典表（码表）
 *
 * @author lvzf 2016年8月2日
 */
//@Entity
//@Table(name = "yyg_sys_dict")
//@DynamicInsert
//@DynamicUpdate
public class SysDictEntity extends BaseEntity {
    /** */
    private static final long serialVersionUID = -5367982356530804098L;
    /**
     * 根节点id
     */
    public static final long ROOT_ID = 0L;
    /**
     * 商品分类
     */
    public static final long ROOT_PRODUCT = 1L;
    /**
     * 品牌
     */
    public static final long ROOT_BRAND = 20L;
    /**
     * 广告位
     */
    public static final long ROOT_ADV = 50L;
    /**
     * 广告位-首页幻灯片
     */
    public static final long ROOT_ADV_HOME_SLIDE = 51L;
    /**
     * 广告位-app首页幻灯片
     */
    public static final long ROOT_ADV_HOME_SLIDE_APP = 52L;
    /**
     * 父节点
     */
//	@Column(nullable = false)
    private Long parentId = ROOT_ID;
    /**
     * 名称
     */
    private String name;
    /**
     * 显示名称
     */
//	@Transient
    private String displayName;

    /**
     * 排序号
     */
//	@Column(nullable = false, columnDefinition = " bigint default 0 ")
    private int seqNo;
    /**
     * 图标
     */
    private String icons;
    /**
     * 是否显示
     */
//	@Column(nullable = false, columnDefinition = " bit default 1 ")
    private boolean display;

    /**
     * 子节点
     */
//	@Transient
    private List<SysDictEntity> children;

    /**
     * 获取 子节点
     *
     * @return
     * @author linwk 2016年8月9日
     */
    public List<SysDictEntity> getChildren() {
        return children;
    }

    /**
     * 设置 子节点
     *
     * @param children
     * @author linwk 2016年8月9日
     */
    public void setChildren(List<SysDictEntity> children) {
        this.children = children;
    }

    /**
     * get parentId
     *
     * @return
     * @author lvzf 2016年8月2日
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * set parentId
     *
     * @param parentId
     * @author lvzf 2016年8月2日
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * get name
     *
     * @return
     * @author lvzf 2016年8月2日
     */
    public String getName() {
        return name;
    }

    /**
     * set name
     *
     * @param name
     * @author lvzf 2016年8月2日
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get seqNo
     *
     * @return
     * @author lvzf 2016年8月3日
     */
    public int getSeqNo() {
        return seqNo;
    }

    /**
     * set seqNo
     *
     * @param seqNo
     * @author lvzf 2016年8月3日
     */
    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }


    /**
     * get icons
     *
     * @return
     * @author lvzf 2016年8月19日
     */
    public String getIcons() {
        return icons;
    }

    /**
     * set icons
     *
     * @param icons
     * @author lvzf 2016年8月19日
     */
    public void setIcons(String icons) {
        this.icons = icons;
    }

    /**
     * get display
     *
     * @return
     * @author lvzf 2016年8月19日
     */
    public boolean isDisplay() {
        return display;
    }

    /**
     * set display
     *
     * @param display
     * @author lvzf 2016年8月19日
     */
    public void setDisplay(boolean display) {
        this.display = display;
    }

    /**
     * get displayName
     *
     * @return
     * @author lvzf 2016年9月6日
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * set displayName
     *
     * @param displayName
     * @author lvzf 2016年9月6日
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

}
