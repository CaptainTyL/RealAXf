package com.example.administrator.realaxf.ui.Base.Home.Bean;

public class AddShopCarBean {


    /**
     * result : 1
     * resultcode : 1
     * msg : 成功
     * data : {"usernumber":"13676973571","username":"13676973571","usericon":"http://questionnaire.dzqcedu.com:81/upload/upload/user/9.jpg","usersex":"女","time":"2018-12-27 10:18:18","viptype":"V0会员","vipintegral":"1"}
     */

    private int result;
    private int resultcode;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * usernumber : 13676973571
         * username : 13676973571
         * usericon : http://questionnaire.dzqcedu.com:81/upload/upload/user/9.jpg
         * usersex : 女
         * time : 2018-12-27 10:18:18
         * viptype : V0会员
         * vipintegral : 1
         */

        private String usernumber;
        private String username;
        private String usericon;
        private String usersex;
        private String time;
        private String viptype;
        private String vipintegral;

        public String getUsernumber() {
            return usernumber;
        }

        public void setUsernumber(String usernumber) {
            this.usernumber = usernumber;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUsericon() {
            return usericon;
        }

        public void setUsericon(String usericon) {
            this.usericon = usericon;
        }

        public String getUsersex() {
            return usersex;
        }

        public void setUsersex(String usersex) {
            this.usersex = usersex;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getViptype() {
            return viptype;
        }

        public void setViptype(String viptype) {
            this.viptype = viptype;
        }

        public String getVipintegral() {
            return vipintegral;
        }

        public void setVipintegral(String vipintegral) {
            this.vipintegral = vipintegral;
        }
    }
}
