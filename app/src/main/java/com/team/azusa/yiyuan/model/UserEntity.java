package com.team.azusa.yiyuan.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 用户表
 *
 * @author lvzf
 */
//@Entity
//@Table(name = "yyg_user")
//@DynamicInsert
//@DynamicUpdate
public class UserEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -1918710199322286827L;

    /**
     * 用户名、会员名
     */
//	@Column(nullable = false)
    private String userName;
    /**
     * 微信 openId
     */
    private String weixinOpenId;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户类型：0-普通会员，1-管理员
     */
//	@Column(nullable = false, columnDefinition = " int default 0 ")
    private int userType;
    /**
     * 是否内部用户
     */
//	@Column(nullable = false, columnDefinition = " bit default 0 ")
    private boolean innerUser;
    /**
     * 昵称：显示用，可以重复
     */
    private String nickName;
    /**
     * 真实姓名
     */
    private String trueName;
    /**
     * 责任人头像
     */
    private String headPhotoPath;
    /**
     * 手机
     */
    private String mobile;
    /**
     * 性别
     */
    private int sex;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 地址
     */
    private String address;
    /**
     * qq号
     */
    private String qq;
    /**
     * 简介、备注、个性签名
     */
//	@Column(length = 512)
    private String remark;
    /**
     * 省份id
     */
    private Long provinceId;
    /**
     * 城市id
     */
    private Long cityId;
    /**
     * 区域id
     */
    private Long areaId;
    /**
     * 身份证号码
     */
    private String cardNo;
    /**
     * 账户余额
     */
//	@Column(nullable = false, columnDefinition = "decimal default 0 ")
    private BigDecimal accountBalance;
    /**
     * 积分余额
     */
//	@Column(nullable = false, columnDefinition = "decimal default 0 ")
    private BigDecimal scoreBalance;
    /**
     * 积分余额
     */
//	@Column(nullable = false, columnDefinition = "decimal default 0 ")
    private BigDecimal hongbaoBalance;
    /**
     * 邀请人
     */
    private Long yaoqingUserId;

    /**
     * api接口的版本号
     */
    private String apiVersion;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getWeixinOpenId() {
        return weixinOpenId;
    }

    public void setWeixinOpenId(String weixinOpenId) {
        this.weixinOpenId = weixinOpenId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public boolean isInnerUser() {
        return innerUser;
    }

    public void setInnerUser(boolean innerUser) {
        this.innerUser = innerUser;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getHeadPhotoPath() {
        return headPhotoPath;
    }

    public void setHeadPhotoPath(String headPhotoPath) {
        this.headPhotoPath = headPhotoPath;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public BigDecimal getScoreBalance() {
        return scoreBalance;
    }

    public void setScoreBalance(BigDecimal scoreBalance) {
        this.scoreBalance = scoreBalance;
    }

    public Long getYaoqingUserId() {
        return yaoqingUserId;
    }

    public void setYaoqingUserId(Long yaoqingUserId) {
        this.yaoqingUserId = yaoqingUserId;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }


    public BigDecimal getHongbaoBalance() {
        return hongbaoBalance;
    }

    public void setHongbaoBalance(BigDecimal hongbaoBalance) {
        this.hongbaoBalance = hongbaoBalance;
    }

    @Override
    public String toString() {
        return "UserEntity [userName=" + userName + ", weixinOpenId=" + weixinOpenId + ", password=" + password + ", userType=" + userType + ", innerUser=" + innerUser + ", nickName=" + nickName
                + ", trueName=" + trueName + ", headPhotoPath=" + headPhotoPath + ", mobile=" + mobile + ", sex=" + sex + ", birthday=" + birthday + ", email=" + email + ", address=" + address
                + ", qq=" + qq + ", remark=" + remark + ", provinceId=" + provinceId + ", cityId=" + cityId + ", areaId=" + areaId + ", cardNo=" + cardNo + ", accountBalance=" + accountBalance
                + ", scoreBalance=" + scoreBalance + ", hongbaoBalance=" + hongbaoBalance + ", yaoqingUserId=" + yaoqingUserId + ", apiVersion=" + apiVersion + "]";
    }
}
