package com.team.azusa.yiyuan.bean;

public class ProductDto {

    private String productId;                //商品ID
    private String yunNumId;    //云期数ID
    private String title;                    //商品标题
    private String imgUrl;                    //商品图片
    private String xianGou;                    //是否为限购，1为是，0为否
    private int daojishi;    //倒计时时间
    private long yunNum;                        //云购期数
    private long value;                        //价值
    private long buyNum;                        //已购买人数
    private long totalNum;                    //总人数

    public ProductDto() {
    }

    public ProductDto(String productId, String title, String imgUrl, String xianGou, long value, long buyNum, long totalNum, long yunNum) {
        this.productId = productId;
        this.title = title;
        this.imgUrl = imgUrl;
        this.xianGou = xianGou;
        this.value = value;
        this.buyNum = buyNum;
        this.totalNum = totalNum;
        this.yunNum = yunNum;
    }

    public String getYunNumId() {
        return yunNumId;
    }

    public void setYunNumId(String yunNumId) {
        this.yunNumId = yunNumId;
    }

    public int getDaojishi() {
        return daojishi;
    }

    public void setDaojishi(int daojishi) {
        this.daojishi = daojishi;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getXianGou() {
        return xianGou;
    }

    public void setXianGou(String xianGou) {
        this.xianGou = xianGou;
    }

    public long getYunNum() {
        return yunNum;
    }

    public void setYunNum(long yunNum) {
        this.yunNum = yunNum;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public long getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(long buyNum) {
        this.buyNum = buyNum;
    }

    public long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(long totalNum) {
        this.totalNum = totalNum;
    }

    public boolean equal(ProductDto o) {
        return this.productId.equals(o.getProductId());
    }
}
