package com.team.azusa.yiyuan.model;

import java.util.List;

/**
 * @author : chenru
 * @功能描述: 晒单类
 * @创建时间: 2019/3/18
 */
public class ShowOrderBean {

    /**
     * id : 31
     * deleteStatus : false
     * version : 1
     * createTime : 2016-10-28 16:42:17
     * createBy : 小冰淇林
     * createById : null
     * lastModifyTime : 2016-10-28 17:05:17
     * lastModifyBy : null
     * lastModifyById : null
     * productId : 10
     * ygProductId : 44
     * ygProduct : null
     * period : 3
     * title : 111
     * content : 111
     * userId : 1000132
     * userNickName : 小冰淇林
     * userLogoPath : http://wx.qlogo.cn/mmopen/PiajxSqBRaEK8jicF7RTzFibIDt2sFE1KIEibIVMGicIoVCuT4nwQS6X2NBE4U9YkNEoc1ibm9VWiawTVDCcSnszFsFWw/0
     * audit : true
     * photos : ["http://www.yyyiduo.com/upload/user/space/1000132/2016/10/28/9e4509d4-093f-4359-aab9-745d00cc1318.png"]
     * recommend : false
     * photoList : ["http://www.yyyiduo.com/upload/user/space/1000132/2016/10/28/9e4509d4-093f-4359-aab9-745d00cc1318.png"]
     */

    public int id;
    public boolean deleteStatus;
    public int version;
    public String createTime;
    public String createBy;
    public Object createById;
    public String lastModifyTime;
    public Object lastModifyBy;
    public Object lastModifyById;
    public int productId;
    public int ygProductId;
    public Object ygProduct;
    public int period;
    public String title;
    public String content;
    public int userId;
    public String userNickName;
    public String userLogoPath;
    public boolean audit;
    public String photos;
    public boolean recommend;
    public List<String> photoList;
}
