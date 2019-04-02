package com.example.administrator.realaxf.ui.Base.Home.Bean;

import java.util.List;

public class ClassShopTypeBean {

    /**
     * result : 0
     * resultcode : 2
     * msg : 失败
     * data : []
     * goodstype : [{"typeid":"1","typename":"热销新品"},{"typeid":"2","typename":"整箱购"},{"typeid":"3","typename":"优选水果"},{"typeid":"4","typename":"饮料酒水"},{"typeid":"5","typename":"卤味熟食"},{"typeid":"6","typename":"牛奶面包"},{"typeid":"7","typename":"冷饮冻食"},{"typeid":"8","typename":"休闲零食"},{"typeid":"9","typename":"方便熟食"},{"typeid":"10","typename":"粮油调味"},{"typeid":"11","typename":"生活用品"},{"typeid":"12","typename":"跑腿代购"}]
     */

    private int result;
    private int resultcode;
    private String msg;
    private List<?> data;
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

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public List<GoodstypeBean> getGoodstype() {
        return goodstype;
    }

    public void setGoodstype(List<GoodstypeBean> goodstype) {
        this.goodstype = goodstype;
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
