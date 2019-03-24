package com.team.azusa.yiyuan.model;

import java.io.Serializable;

/**
 * 系统附件表<br/>
 * 包含图片等等
 *
 * @author lvzf
 */
//@Entity
//@Table(name = "yyg_accessory")
public class AccessoryEntity extends BaseEntity implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 6403921248194220302L;
    /**
     * 文件名称
     */
    private String name;
    /**
     * 文件相对路径
     */
    private String path;
    /**
     * 文件大小
     */
    private float size;
    /**
     * 图片宽
     */
    private int width;
    /**
     * 图片高
     */
    private int height;
    /**
     * 文件格式后缀
     */
    private String ext;
    /**
     * 备注信息
     */
    private String info;
    /**
     * 所属相册
     */
//	@Column(name="album_id")
    private Long albumId;
    /**
     * 上传用户id
     */
//	@Column(name="user_id")
    private Long userId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


}
