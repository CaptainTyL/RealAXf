package com.example.administrator.realaxf.ui.Base.Home.Bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DeleteShopBean {

    /**
     * result : 1
     * resultcode : 1
     * msg : 成功
     * data : [{"commodityid":"84","commoditytype":"生活用品","commoditynumber":"2","smallcommodityimage":"http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21b89063cd4.png","bigcommodityimage":"http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21b89063128.png","commoditytitle":"汰渍洗衣液500l","500g":"500g","commoditydescribe":"强力去污","price":"39","vipprice":"36"},{"commodityid":"85","commoditytype":"优选水果","commoditynumber":"1","smallcommodityimage":"http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21b9a02d947.png","bigcommodityimage":"http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21b9a02cf9a.png","commoditytitle":"樱头沟大樱桃","500g":"500g","commoditydescribe":"郑州樱桃沟特产","price":"18","vipprice":"17"},{"commodityid":"88","commoditytype":"饮料酒水","commoditynumber":"1","smallcommodityimage":"http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21ba85133f1.jpg","bigcommodityimage":"http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21ba8512326.jpg","commoditytitle":"可口可乐250ml","500g":"500g","commoditydescribe":"大瓶装新包装","price":"5","vipprice":"4"},{"commodityid":"304","commoditytype":"饮料酒水","commoditynumber":"1","smallcommodityimage":"http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21e434e8bf8.jpg","bigcommodityimage":"http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21e434e83c0.jpg","commoditytitle":"法国干红500ml","500g":"500g","commoditydescribe":"正宗干红","price":"288","vipprice":"266"},{"commodityid":"71","commoditytype":"整箱购","commoditynumber":"1","smallcommodityimage":"http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21a9286718b.jpg","bigcommodityimage":"http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21a9286610b.jpg","commoditytitle":"珊琪玛","500g":"500g","commoditydescribe":"大盒装","price":"18","vipprice":"17"}]
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
         * commodityid : 84
         * commoditytype : 生活用品
         * commoditynumber : 2
         * smallcommodityimage : http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21b89063cd4.png
         * bigcommodityimage : http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21b89063128.png
         * commoditytitle : 汰渍洗衣液500l
         * 500g : 500g
         * commoditydescribe : 强力去污
         * price : 39
         * vipprice : 36
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
