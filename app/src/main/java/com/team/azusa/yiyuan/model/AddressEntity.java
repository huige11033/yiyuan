package com.team.azusa.yiyuan.model;

/**
 * 用户收货地址
 *
 * @author linwk 2016年10月5日
 */
//@Entity
//@Table(name = "ygg_address")
//@DynamicInsert
//@DynamicUpdate
public class AddressEntity extends BaseEntity {
    /**
     *
     */
    private static final long serialVersionUID = -7486571039896175088L;
    /**
     * 姓名
     */
    private String trueName;

    /**
     * 省份id
     */
    private Long provinceId;
    private String provinceName;
    /**
     * 城市id
     */
    private Long cityId;
    private String cityName;
    /**
     * 区域id
     */
    private Long areaId;
    private String areaName;

    /**
     * 详细地址
     */
    private String areaInfo;
    /**
     * 邮编
     */
    private String zip;
    /**
     * 手机
     */
    private String telephone;
    /**
     * 联系电话
     */
    private String mobile;
    /**
     * 所属用户
     */
    private Long userId;

    /**
     * 是否默认地址 0 1是
     */
    private int isDefaultAddress;

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    /**
     * get provinceId
     *
     * @return
     * @author linwk 2016年10月8日
     */
    public Long getProvinceId() {
        return provinceId;
    }

    /**
     * set provinceId
     *
     * @param provinceId
     * @author linwk 2016年10月8日
     */
    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * get provinceName
     *
     * @return
     * @author linwk 2016年10月8日
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * set provinceName
     *
     * @param provinceName
     * @author linwk 2016年10月8日
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    /**
     * get cityId
     *
     * @return
     * @author linwk 2016年10月8日
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * set cityId
     *
     * @param cityId
     * @author linwk 2016年10月8日
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    /**
     * get cityName
     *
     * @return
     * @author linwk 2016年10月8日
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * set cityName
     *
     * @param cityName
     * @author linwk 2016年10月8日
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * get areaName
     *
     * @return
     * @author linwk 2016年10月8日
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * set areaName
     *
     * @param areaName
     * @author linwk 2016年10月8日
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    /**
     * 详细地址
     */
    public String getAreaInfo() {
        return areaInfo;
    }

    public void setAreaInfo(String areaInfo) {
        this.areaInfo = areaInfo;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * get isDefaultAddress
     *
     * @return
     * @author linwk 2016年10月8日
     */
    public int getIsDefaultAddress() {
        return isDefaultAddress;
    }

    /**
     * set isDefaultAddress
     *
     * @param isDefaultAddress
     * @author linwk 2016年10月8日
     */
    public void setIsDefaultAddress(int isDefaultAddress) {
        this.isDefaultAddress = isDefaultAddress;
    }

}
