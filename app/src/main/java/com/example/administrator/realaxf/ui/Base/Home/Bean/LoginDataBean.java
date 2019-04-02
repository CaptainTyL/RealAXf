package com.example.administrator.realaxf.ui.Base.Home.Bean;

public class LoginDataBean {


    /**
     * result : 1
     * resultcode : 1
     * msg : 成功
     * data : {"verification":1376}
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
         * verification : 1376
         */

        private int verification;

        public int getVerification() {
            return verification;
        }

        public void setVerification(int verification) {
            this.verification = verification;
        }
    }
}
