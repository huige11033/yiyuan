package com.team.azusa.yiyuan.model;

import java.io.Serializable;


/**
 * 快递公司
 *
 * @author lvzf
 */
//@Entity
//@Table(name = "yyg_express_com")
public class ExpressComEntity extends BaseEntity implements Serializable {

    /** */
    private static final long serialVersionUID = 4412375385161241571L;
    /**
     * 公司名称
     */
    private String name;
    /**
     * 快递公司接口地址
     */
    private String url;
    /**
     * 公司logo
     */
    private String logoPath;

    /**
     * get name
     *
     * @return
     * @author lvzf 2016年10月11日
     */
    public String getName() {
        return name;
    }

    /**
     * set name
     *
     * @param name
     * @author lvzf 2016年10月11日
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get url
     *
     * @return
     * @author lvzf 2016年10月11日
     */
    public String getUrl() {
        return url;
    }

    /**
     * set url
     *
     * @param url
     * @author lvzf 2016年10月11日
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * get logoPath
     *
     * @return
     * @author lvzf 2016年10月11日
     */
    public String getLogoPath() {
        return logoPath;
    }

    /**
     * set logoPath
     *
     * @param logoPath
     * @author lvzf 2016年10月11日
     */
    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }


}
