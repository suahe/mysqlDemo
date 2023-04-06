package com.example.demo.bean;

/**
 * @author zcx
 * @Title 创建大批量推送消息返回结果类
 * @date 2019年05月09日 17:20
 **/
public class CreatePushResult {

    /**
     * result : {"push_id":2324924018}
     * err_msg :
     * ret_code : 0
     */
    private ResultEntity result;
    private String err_msg;
    private int ret_code;

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public void setErr_msg(String err_msg) {
        this.err_msg = err_msg;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public ResultEntity getResult() {
        return result;
    }

    public String getErr_msg() {
        return err_msg;
    }

    public int getRet_code() {
        return ret_code;
    }

    public class ResultEntity {
        /**
         * push_id : 2324924018
         */
        private long push_id;

        public void setPush_id(long push_id) {
            this.push_id = push_id;
        }

        public long getPush_id() {
            return push_id;
        }
    }
}
