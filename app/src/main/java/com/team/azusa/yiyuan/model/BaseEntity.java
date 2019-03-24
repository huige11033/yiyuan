package com.team.azusa.yiyuan.model;

import java.io.Serializable;
import java.util.Date;

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
    private Date createTime;
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
    private Date lastModifyTime;
    /**
     * 最后修改人.
     */
    private String lastModifyBy;
    /**
     * 最后修改人.
     */
    private Long lastModifyById;
}