package com.csqf.zx.restult;

import com.csqf.zx.system.SystemInfo;
import lombok.Data;

/**
 * 日期: 2023年7月29
 * 作者: XinForever
 */
@Data
public class ResponseResult<T> {

    private Long code;
    private String message;
    private T data;

    public ResponseResult(Long code){
        this.code = code;
    }

    public static ResponseResult SUCCESS(){
        return new ResponseResult(SystemInfo.SYSTEM_SUCCESS_CODE);
    }

    public static ResponseResult FAIL(){
        return new ResponseResult(SystemInfo.SYSTEM_FAIL_CODE);
    }
}
