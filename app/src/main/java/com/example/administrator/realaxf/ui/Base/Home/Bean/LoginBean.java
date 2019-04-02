package com.example.administrator.realaxf.ui.Base.Home.Bean;

public class LoginBean {

    /**
     * result : 1
     * resultcode : 1
     * msg : 成功
     * data : {"userId":"673","userNumber":"13683829056","userName":"13683829056","userIcon":"http://questionnaire.dzqcedu.com:81/upload/user/1.jpg","userAge":"19","userSex":"男","time":"2018-12-24 18:11:22","vipType":"V0会员","vipIntegral":"1"}
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
         * userId : 673
         * userNumber : 13683829056
         * userName : 13683829056
         * userIcon : http://questionnaire.dzqcedu.com:81/upload/user/1.jpg
         * userAge : 19
         * userSex : 男
         * time : 2018-12-24 18:11:22
         * vipType : V0会员
         * vipIntegral : 1
         */

        private String userId;
        private String userNumber;
        private String userName;
        private String userIcon;
        private String userAge;
        private String userSex;
        private String time;
        private String vipType;
        private String vipIntegral;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserNumber() {
            return userNumber;
        }

        public void setUserNumber(String userNumber) {
            this.userNumber = userNumber;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserIcon() {
            return userIcon;
        }

        public void setUserIcon(String userIcon) {
            this.userIcon = userIcon;
        }

        public String getUserAge() {
            return userAge;
        }

        public void setUserAge(String userAge) {
            this.userAge = userAge;
        }

        public String getUserSex() {
            return userSex;
        }

        public void setUserSex(String userSex) {
            this.userSex = userSex;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getVipType() {
            return vipType;
        }

        public void setVipType(String vipType) {
            this.vipType = vipType;
        }

        public String getVipIntegral() {
            return vipIntegral;
        }

        public void setVipIntegral(String vipIntegral) {
            this.vipIntegral = vipIntegral;
        }
    }
}
