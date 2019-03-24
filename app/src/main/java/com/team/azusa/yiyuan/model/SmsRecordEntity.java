package com.team.azusa.yiyuan.model;

/**
 * 短信发送记录
 *
 * @author lvzf 2016年8月19日
 */
//@Entity
//@Table(name = "ygg_sms_record")
//@DynamicInsert
//@DynamicUpdate
public class SmsRecordEntity extends BaseEntity {

    /** */
    private static final long serialVersionUID = -4288485753322757591L;

    /**
     * 手机号码
     */
//	@Column(nullable = false)
    private String mobile;
    //	@Column(columnDefinition = "longtext COMMENT '发送内容'", nullable = false)
    private String content;
    /**
     * 短信相应内容
     */
//	@Column(columnDefinition = "longtext COMMENT '短信相应内容'", nullable = false)
    private String body;

    /**
     * get mobile
     *
     * @return
     * @author lvzf 2016年9月22日
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * set mobile
     *
     * @param mobile
     * @author lvzf 2016年9月22日
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * get content
     *
     * @return
     * @author lvzf 2016年9月22日
     */
    public String getContent() {
        return content;
    }

    /**
     * set content
     *
     * @param content
     * @author lvzf 2016年9月22日
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * get body
     *
     * @return
     * @author lvzf 2016年9月22日
     */
    public String getBody() {
        return body;
    }

    /**
     * set body
     *
     * @param body
     * @author lvzf 2016年9月22日
     */
    public void setBody(String body) {
        this.body = body;
    }


}
