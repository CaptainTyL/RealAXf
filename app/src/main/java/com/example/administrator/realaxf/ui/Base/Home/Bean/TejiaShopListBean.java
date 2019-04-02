package com.example.administrator.realaxf.ui.Base.Home.Bean;

import java.util.List;

public class TejiaShopListBean {

    /**
     * result : 0
     * resultcode : 2
     * msg : 成功
     * data : [{"goodsid":"70","goodsname":"麻辣卫龙小面筋","goodsdescript":"特别辣有还吃","goodsbigurl":"http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21a8ed5e932.jpg","goodssmallurl":"http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21a8ed6357c.jpg","goodsprice":"5","goodsvipprice":"4","typeid":"1","listtype":"0","createdate":"2018-12-25 11:50:05","mark":"13676973571","typename":"热销新品"},{"goodsid":"71","goodsname":"珊琪玛","goodsdescript":"大盒装","goodsbigurl":"http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21a9286610b.jpg","goodssmallurl":"http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21a9286718b.jpg","goodsprice":"18","goodsvipprice":"17","typeid":"2","listtype":"0","createdate":"2018-12-25 11:51:04","mark":"13676973571","typename":"整箱购"},{"goodsid":"72","goodsname":"好吃的板栗","goodsdescript":"张哥板栗好吃不贵","goodsbigurl":"http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21a95da5970.jpg","goodssmallurl":"http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21a95da6617.jpg","goodsprice":"28","goodsvipprice":"26","typeid":"8","listtype":"0","createdate":"2018-12-25 11:51:57","mark":"13676973571","typename":"休闲零食"},{"goodsid":"73","goodsname":"雀巢脆脆鲨100g","goodsdescript":"好吃","goodsbigurl":"http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21aacc9da2b.jpg","goodssmallurl":"http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21aacc9ea6a.jpg","goodsprice":"18","goodsvipprice":"17","typeid":"8","listtype":"0","createdate":"2018-12-25 11:58:04","mark":"13676973571","typename":"休闲零食"}]
     * goodstype : [{"typeid":"1","typename":"热销新品"},{"typeid":"2","typename":"整箱购"},{"typeid":"3","typename":"优选水果"},{"typeid":"4","typename":"饮料酒水"},{"typeid":"5","typename":"卤味熟食"},{"typeid":"6","typename":"牛奶面包"},{"typeid":"7","typename":"冷饮冻食"},{"typeid":"8","typename":"休闲零食"},{"typeid":"9","typename":"方便熟食"},{"typeid":"10","typename":"粮油调味"},{"typeid":"11","typename":"生活用品"},{"typeid":"12","typename":"跑腿代购"}]
     */

    private int result;
    private int resultcode;
    private String msg;
    private List<DataBean> data;
    private List<GoodstypeBean> goodstype;

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

    public List<GoodstypeBean> getGoodstype() {
        return goodstype;
    }

    public void setGoodstype(List<GoodstypeBean> goodstype) {
        this.goodstype = goodstype;
    }

    public static class DataBean {
        /**
         * goodsid : 70
         * goodsname : 麻辣卫龙小面筋
         * goodsdescript : 特别辣有还吃
         * goodsbigurl : http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21a8ed5e932.jpg
         * goodssmallurl : http://questionnaire.dzqcedu.com:81/upload/2018-12-25/5c21a8ed6357c.jpg
         * goodsprice : 5
         * goodsvipprice : 4
         * typeid : 1
         * listtype : 0
         * createdate : 2018-12-25 11:50:05
         * mark : 13676973571
         * typename : 热销新品
         */

        private String goodsid;
        private String goodsname;
        private String goodsdescript;
        private String goodsbigurl;
        private String goodssmallurl;
        private String goodsprice;
        private String goodsvipprice;
        private String typeid;
        private String listtype;
        private String createdate;
        private String mark;
        private String typename;

        public String getGoodsid() {
            return goodsid;
        }

        public void setGoodsid(String goodsid) {
            this.goodsid = goodsid;
        }

        public String getGoodsname() {
            return goodsname;
        }

        public void setGoodsname(String goodsname) {
            this.goodsname = goodsname;
        }

        public String getGoodsdescript() {
            return goodsdescript;
        }

        public void setGoodsdescript(String goodsdescript) {
            this.goodsdescript = goodsdescript;
        }

        public String getGoodsbigurl() {
            return goodsbigurl;
        }

        public void setGoodsbigurl(String goodsbigurl) {
            this.goodsbigurl = goodsbigurl;
        }

        public String getGoodssmallurl() {
            return goodssmallurl;
        }

        public void setGoodssmallurl(String goodssmallurl) {
            this.goodssmallurl = goodssmallurl;
        }

        public String getGoodsprice() {
            return goodsprice;
        }

        public void setGoodsprice(String goodsprice) {
            this.goodsprice = goodsprice;
        }

        public String getGoodsvipprice() {
            return goodsvipprice;
        }

        public void setGoodsvipprice(String goodsvipprice) {
            this.goodsvipprice = goodsvipprice;
        }

        public String getTypeid() {
            return typeid;
        }

        public void setTypeid(String typeid) {
            this.typeid = typeid;
        }

        public String getListtype() {
            return listtype;
        }

        public void setListtype(String listtype) {
            this.listtype = listtype;
        }

        public String getCreatedate() {
            return createdate;
        }

        public void setCreatedate(String createdate) {
            this.createdate = createdate;
        }

        public String getMark() {
            return mark;
        }

        public void setMark(String mark) {
            this.mark = mark;
        }

        public String getTypename() {
            return typename;
        }

        public void setTypename(String typename) {
            this.typename = typename;
        }
    }

    public static class GoodstypeBean {
        /**
         * typeid : 1
         * typename : 热销新品
         */

        private String typeid;
        private String typename;

        public String getTypeid() {
            return typeid;
        }

        public void setTypeid(String typeid) {
            this.typeid = typeid;
        }

        public String getTypename() {
            return typename;
        }

        public void setTypename(String typename) {
            this.typename = typename;
        }
    }
}
