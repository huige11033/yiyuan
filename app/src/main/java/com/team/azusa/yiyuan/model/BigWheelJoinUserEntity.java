package com.team.azusa.yiyuan.model;

/**
 * 大转盘，参于用户信息表
 *
 * @author nibili 2016年6月1日
 */
//@Entity
//@Table(name = "yyg_big_wheel_join_user")
//@DynamicInsert
//@DynamicUpdate
public class BigWheelJoinUserEntity extends BaseEntity {

    /** */
    private static final long serialVersionUID = -6605388940596501799L;
    /**
     * 大转盘id
     */
//	@Column(nullable = false)
    private Long bigWheelId;
    /**
     * 用户名字
     */
    private String name;
    /**
     * 用户手机
     */
    private String tel;
    /**
     * 用户qq
     */
    private String qq;
    /**
     * 微信号
     */
    private String weixin;
    /**
     * 地址
     */
    private String address;
    /**
     * 邮件地址
     */
    private String email;
    /**
     * 是否用户信息已提交
     */
    private boolean isUserInfoCommited;

    /**
     * get 大转盘id
     *
     * @return
     * @author nibili 2016年6月1日
     */
    public Long getBigWheelId() {
        return bigWheelId;
    }

    /**
     * set 大转盘id
     *
     * @param bigWheelId
     * @author nibili 2016年6月1日
     */
    public void setBigWheelId(Long bigWheelId) {
        this.bigWheelId = bigWheelId;
    }

    /**
     * get 用户名字
     *
     * @return
     * @author nibili 2016年6月1日
     */
    public String getName() {
        return name;
    }

    /**
     * set 用户名字
     *
     * @param name
     * @author nibili 2016年6月1日
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get 用户qq
     *
     * @return
     * @author nibili 2016年6月1日
     */
    public String getQq() {
        return qq;
    }

    /**
     * set 用户qq
     *
     * @param 用户qq
     * @author nibili 2016年6月1日
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * get 微信号
     *
     * @return
     * @author nibili 2016年6月1日
     */
    public String getWeixin() {
        return weixin;
    }

    /**
     * set 微信号
     *
     * @param weixin
     * @author nibili 2016年6月1日
     */
    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    /**
     * get 地址
     *
     * @return
     * @author nibili 2016年6月1日
     */
    public String getAddress() {
        return address;
    }

    /**
     * set 地址
     *
     * @param address
     * @author nibili 2016年6月1日
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * get 邮件地址
     *
     * @return
     * @author nibili 2016年6月1日
     */
    public String getEmail() {
        return email;
    }

    /**
     * set 邮件地址
     *
     * @param email
     * @author nibili 2016年6月1日
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * get 用户手机
     *
     * @return
     * @author nibili 2016年6月3日
     */
    public String getTel() {
        return tel;
    }

    /**
     * set 用户手机
     *
     * @param tel
     * @author nibili 2016年6月3日
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * get 是否用户信息已提交
     *
     * @return
     * @author nibili 2016年6月6日
     */
    public boolean getIsUserInfoCommited() {
        return isUserInfoCommited;
    }

    /**
     * set 是否用户信息已提交
     *
     * @param isUserInfoCommited
     * @author nibili 2016年6月6日
     */
    public void setIsUserInfoCommited(boolean isUserInfoCommited) {
        this.isUserInfoCommited = isUserInfoCommited;
    }

}
