package com.alpaca.SSMDemo.utils;

import java.util.Map;

/**
 * Created by daixueyun on 2019/7/18 0018.
 */
public class AjaxJson {

    private boolean success = true;
    private String msg = "";
    private Object obj = null;
    private Map<String, Object> attributes;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
}
