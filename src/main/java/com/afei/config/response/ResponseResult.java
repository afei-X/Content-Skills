package com.afei.config.response;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.poi.ss.formula.functions.T;

import static com.afei.config.response.ReturnCode.RETURN_CODE_0;
import static com.afei.config.response.ReturnCode.RETURN_CODE_500;


@Setter
@Getter
@ToString
public class ResponseResult  {

    private int code;

    private String message;

    private T result;

    public static final ResponseResult SUCCESS = new ResponseResult(RETURN_CODE_0.getCode(),"success");
    public static final ResponseResult FAIL = new ResponseResult(RETURN_CODE_500.getCode(),"fail");

    public ResponseResult(){};

    public ResponseResult(int code, String message) {

        this.code=code;
        this.message=message;
    }
    public ResponseResult(int code, String message, T result) {
        this.code=code;
        this.message=message;
        this.result = result;
    }


    public static ResponseResult success (String message) {
        return new ResponseResult(RETURN_CODE_0.getCode(),message);
    }

    public static ResponseResult success (T result) {
        return new ResponseResult(RETURN_CODE_0.getCode(),"success",result);
    }

    public static ResponseResult success (T result,String message) {
        if(message == null) message = RETURN_CODE_0.getMsg();
        return new ResponseResult(RETURN_CODE_0.getCode(),message,result);
    }

    public static ResponseResult fail (T result,String message) {
        return new ResponseResult(RETURN_CODE_500.getCode(),message,result);
    }

    /**
     * 默认错误码是500
     * @param message
     * @return
     */
    public static ResponseResult fail (String message) {
        return new ResponseResult(RETURN_CODE_500.getCode(),message);
    }

    /**
     * 自定义错误码
     * @param code
     * @return
     */
    public static ResponseResult fail (ReturnCode code,String msg) {
        return new ResponseResult(code.getCode(),msg + code.getMsg());
    }


    public static ResponseResult fail(int code, String msg, T result) {
        return new ResponseResult(code, msg, result);
    }

    /**
     * 自定义错误码
     * @param code
     * @return
     */
    public static ResponseResult fail (ReturnCode code) {
        return new ResponseResult(code.getCode(), code.getMsg());
    }


}
