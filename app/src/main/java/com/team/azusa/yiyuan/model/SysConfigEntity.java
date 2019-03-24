package com.team.azusa.yiyuan.model;

/**
 * 系统配置表
 *
 * @author lvzf 2016年10月12日
 */
//@Entity
//@Table(name = "yyg_sys_config")
//@DynamicInsert
//@DynamicUpdate
public class SysConfigEntity extends BaseEntity {

    /** */
    private static final long serialVersionUID = -3845289366914015892L;
    /**
     * 1-积分规则配置
     */
    public static final long ID_SCORE = 1;
    /**
     * 公共配置
     */
    public static final long ID_COMMON = 2;
    /**
     * 备注
     */
    private String remark;
    /**
     * json数据
     */
    private String data;

//    public Map<String, String> getDataMap() {
//        if (StringUtils.isBlank(data)) {
//            return null;
//        }
//        @SuppressWarnings("unchecked")
//        Map<String, String> dataMap = FastJSONUtils.toObject(data, Map.class);
//        return dataMap;
//    }

    /**
     * get remark
     *
     * @return
     * @author lvzf 2016年10月12日
     */
    public String getRemark() {
        return remark;
    }

    /**
     * set remark
     *
     * @param remark
     * @author lvzf 2016年10月12日
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * get data
     *
     * @return
     * @author lvzf 2016年10月12日
     */
    public String getData() {
        return data;
    }

    /**
     * set data
     *
     * @param data
     * @author lvzf 2016年10月12日
     */
    public void setData(String data) {
        this.data = data;
    }


}
