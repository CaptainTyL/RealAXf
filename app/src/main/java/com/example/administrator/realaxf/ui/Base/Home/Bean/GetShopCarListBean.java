package com.example.administrator.realaxf.ui.Base.Home.Bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetShopCarListBean {

    /**
     * result : 1
     * resultcode : 1
     * msg : 成功
     * data : [{"commodityid":"74","commoditytype":"生活用品","commoditynumber":"1","smallcommodityimage":"http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21b6b0baf73.jpg","bigcommodityimage":"http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21b6b0ba7b4.jpg","commoditytitle":"格力热水壶","500g":"500g","commoditydescribe":"质量有保证","price":"49","vipprice":"48"},{"commodityid":"73","commoditytype":"休闲零食","commoditynumber":"1","smallcommodityimage":"http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21aacc9ea6a.jpg","bigcommodityimage":"http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21aacc9da2b.jpg","commoditytitle":"雀巢脆脆鲨100g","500g":"500g","commoditydescribe":"好吃","price":"18","vipprice":"17"},{"commodityid":"76","commoditytype":"生活用品","commoditynumber":"1","smallcommodityimage":"http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21b7c96a8bb.jpg","bigcommodityimage":"http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21b7c96779f.jpg","commoditytitle":"格力强力吹风机","500g":"500g","commoditydescribe":"飘飘秀发的最爱","price":"28","vipprice":"27"},{"commodityid":"84","commoditytype":"生活用品","commoditynumber":"1","smallcommodityimage":"http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21b89063cd4.png","bigcommodityimage":"http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21b89063128.png","commoditytitle":"汰渍洗衣液500l","500g":"500g","commoditydescribe":"强力去污","price":"39","vipprice":"36"}]
     */

    private int result;
    private int resultcode;
    private String msg;
    private List<DataBean> data;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getResultcode() {
        return resultcode;
    }

    public void setResultcode(int resultcode) {
        this.resultcode = resultcode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * commodityid : 74
         * commoditytype : 生活用品
         * commoditynumber : 1
         * smallcommodityimage : http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21b6b0baf73.jpg
         * bigcommodityimage : http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21b6b0ba7b4.jpg
         * commoditytitle : 格力热水壶
         * 500g : 500g
         * commoditydescribe : 质量有保证
         * price : 49
         * vipprice : 48
         */

        private String commodityid;
        private String commoditytype;
        private String commoditynumber;
        private String smallcommodityimage;
        private String bigcommodityimage;
        private String commoditytitle;
        @SerializedName("500g")
        private String _$500g;
        private String commoditydescribe;
        private String price;
        private String vipprice;

        private boolean check;

        public boolean isCheck() {
            return check;
        }

        public void setCheck(boolean check) {
            this.check = check;
        }

        public String getCommodityid() {
            return commodityid;
        }

        public void setCommodityid(String commodityid) {
            this.commodityid = commodityid;
        }

        public String getCommoditytype() {
            return commoditytype;
        }

        public void setCommoditytype(String commoditytype) {
            this.commoditytype = commoditytype;
        }

        public String getCommoditynumber() {
            return commoditynumber;
        }

        public void setCommoditynumber(String commoditynumber) {
            this.commoditynumber = commoditynumber;
        }

        public String getSmallcommodityimage() {
            return smallcommodityimage;
        }

        public void setSmallcommodityimage(String smallcommodityimage) {
            this.smallcommodityimage = smallcommodityimage;
        }

        public String getBigcommodityimage() {
            return bigcommodityimage;
        }

        public void setBigcommodityimage(String bigcommodityimage) {
            this.bigcommodityimage = bigcommodityimage;
        }

        public String getCommoditytitle() {
            return commoditytitle;
        }

        public void setCommoditytitle(String commoditytitle) {
            this.commoditytitle = commoditytitle;
        }

        public String get_$500g() {
            return _$500g;
        }

        public void set_$500g(String _$500g) {
            this._$500g = _$500g;
        }

        public String getCommoditydescribe() {
            return commoditydescribe;
        }

        public void setCommoditydescribe(String commoditydescribe) {
            this.commoditydescribe = commoditydescribe;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getVipprice() {
            return vipprice;
        }

        public void setVipprice(String vipprice) {
            this.vipprice = vipprice;
        }
    }
}
