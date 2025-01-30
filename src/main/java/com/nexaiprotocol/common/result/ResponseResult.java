package com.nexaiprotocol.common.result;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @since 1.0
 */

@Data
public class ResponseResult implements Serializable {

    private Map<String, Object> data = new HashMap<>();
    private Boolean status;
    private Integer code;
    private String msg;
    private Long time;

    private ResponseResult() {

    }

    public static ResponseResult success() {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setStatus(true);
        responseResult.setCode(ResultCode.SUCCESS);
        responseResult.setMsg("success");
        responseResult.setTime(System.currentTimeMillis());
        return responseResult;
    }

    public static ResponseResult error() {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setStatus(false);
        responseResult.setCode(ResultCode.ERROR);
        responseResult.setMsg("error");
        responseResult.setTime(System.currentTimeMillis());
        return responseResult;
    }


    public ResponseResult status(Boolean success) {
        this.setStatus(success);
        return this;
    }

    public ResponseResult msg(String message) {
        this.setMsg(message);
        return this;
    }

    public ResponseResult code(Integer code) {
        this.setCode(code);
        return this;
    }

    public ResponseResult data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public ResponseResult data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }
}
