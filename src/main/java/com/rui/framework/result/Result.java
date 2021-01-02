package com.rui.framework.result;

import java.io.Serializable;

public class Result implements Serializable {

    public static Result success(){
        return new Result(ResultCode.SUCCESS);
    }

    public static Result success(Object data){
        return new Result(ResultCode.SUCCESS, data);
    }

    public static Result failure(ResultCode resultCode){
        return new Result(resultCode);
    }

    public static Result failure(ResultCode resultCode, Object data){
        return new Result(resultCode, data);
    }

    private Integer code;
    private String message;
    private Object data;

    public Result(){
    }

    public Result(ResultCode resultCode){
        this(resultCode,null);
    }

    public Result(ResultCode resultCode, Object data){
        this();
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
