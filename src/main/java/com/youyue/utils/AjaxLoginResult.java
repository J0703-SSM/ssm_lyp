package com.youyue.utils;

/**
 * Created by dllo on 17/11/8.
 */
public class AjaxLoginResult<T> {

    private int errorCode;  // 响应码
    private String message; // 当返回错误时, 给出错误提示
    private String mess;
    private String phonemess;
    private String eamilmess;
    private T data;      // 用户对象

    public String getEamilmess() {
        return eamilmess;
    }

    public void setEamilmess(String eamilmess) {
        this.eamilmess = eamilmess;
    }

    public String getPhonemess() {
        return phonemess;
    }

    public void setPhonemess(String phonemess) {
        this.phonemess = phonemess;
    }

    public AjaxLoginResult(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public AjaxLoginResult(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public AjaxLoginResult() {
    }

    public AjaxLoginResult(int errorCode, String message, T data) {
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    @Override
    public String toString() {
        return "AjaxLoginResult{" +
                "errorCode=" + errorCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
