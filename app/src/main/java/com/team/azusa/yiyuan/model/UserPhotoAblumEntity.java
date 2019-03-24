package com.team.azusa.yiyuan.model;

import java.io.Serializable;

/**
 * 用户相册
 *
 * @author lvzf 2016年9月11日
 */
//@Entity
//@Table(name = "yyg_user_photo_ablum")
//@DynamicInsert
//@DynamicUpdate
public class UserPhotoAblumEntity extends BaseEntity implements Serializable {
    /** */
    private static final long serialVersionUID = 4186830320183112457L;
    /**
     * 根节点id
     */
    public static final long ROOT_ID = 0L;
    private Long userId;
    private Long parentId;
    private String name;
    /**
     * 父节点名称
     */
//	@Transient
    private String parentName;
    /**
     * 显示名称
     */
//	@Transient
    private String displayName;

    /**
     * get userId
     *
     * @return
     * @author lvzf 2016年9月11日
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * set userId
     *
     * @param userId
     * @author lvzf 2016年9月11日
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * get parentId
     *
     * @return
     * @author lvzf 2016年9月11日
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * set parentId
     *
     * @param parentId
     * @author lvzf 2016年9月11日
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * get name
     *
     * @return
     * @author lvzf 2016年9月11日
     */
    public String getName() {
        return name;
    }

    /**
     * set name
     *
     * @param name
     * @author lvzf 2016年9月11日
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get displayName
     *
     * @return
     * @author lvzf 2016年9月11日
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * set displayName
     *
     * @param displayName
     * @author lvzf 2016年9月11日
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * get parentName
     *
     * @return
     * @author lvzf 2016年9月12日
     */
    public String getParentName() {
        return parentName;
    }

    /**
     * set parentName
     *
     * @param parentName
     * @author lvzf 2016年9月12日
     */
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

}
