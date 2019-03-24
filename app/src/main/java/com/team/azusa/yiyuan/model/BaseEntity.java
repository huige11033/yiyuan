package com.team.azusa.yiyuan.model;

import java.io.Serializable;
import java.sql.Date;

public abstract class BaseEntity implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 45586345374901436L;

    /**
     * 实体主键.
     */
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 是否删除状态
     */
//	@Column(columnDefinition = " bit default 0 ")
    private boolean deleteStatus = false;
    /**
     * 实体版本
     */
//	@Version
//	@Column(columnDefinition = " bigint default 0 ")
    private long version = 0l;
    /**
     * 创建时间.
     */
    private String createTime;
    /**
     * 创建人.
     */
    private String createBy;
    /**
     * 创建人.
     */
    private Long createById;
    /**
     * 最后修改时间.
     */
    private String lastModifyTime;
    /**
     * 最后修改人.
     */
    private String lastModifyBy;
    /**
     * 最后修改人.
     */
    private Long lastModifyById;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Long getCreateById() {
        return createById;
    }

    public void setCreateById(Long createById) {
        this.createById = createById;
    }

    public String getLastModifyBy() {
        return lastModifyBy;
    }

    public void setLastModifyBy(String lastModifyBy) {
        this.lastModifyBy = lastModifyBy;
    }

    public Long getLastModifyById() {
        return lastModifyById;
    }

    public void setLastModifyById(Long lastModifyById) {
        this.lastModifyById = lastModifyById;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(String lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}