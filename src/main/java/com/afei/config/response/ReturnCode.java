package com.afei.config.response;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;

@Getter
@Setter
@ToString
public final class ReturnCode {
    public static final ReturnCode
            RETURN_CODE_0 = new ReturnCode(0, "成功"),
            RETURN_CODE_500 = new ReturnCode(301200000, "服务器错误"),
            RETURN_CODE_301200001 = new ReturnCode(301200001, "参数不能为空"),
            RETURN_CODE_301200002 = new ReturnCode(301200002, "不支持的报表类型"),
            RETURN_CODE_301200003 = new ReturnCode(301200003, "报表不存在"),
            RETURN_CODE_301200004 = new ReturnCode(301200004, "查询结果为空"),
            RETURN_CODE_301200005 = new ReturnCode(301200005, "参数格式不正确"),
            RETURN_CODE_301200006 = new ReturnCode(301200006, "参数错误"),
            RETURN_CODE_301200007 = new ReturnCode(301200007, "位置参数计算失败"),
            RETURN_CODE_301200008 = new ReturnCode(301200008, "* 公式格式有误，请修改"),
            RETURN_CODE_301200009 = new ReturnCode(301200009, "报表字段已删除"),
            RETURN_CODE_301200010 = new ReturnCode(301200010, "登陆异常,请重新登陆"),
            RETURN_CODE_301200011 = new ReturnCode(301200011, "请勿重复点击"),
            RETURN_CODE_301200012 = new ReturnCode(301200012, "redis分布式锁解锁失败"),
            RETURN_CODE_301200013 = new ReturnCode(301200013, "不合法操作，请稍后操作");


    private final Integer code;
    private final String msg;

    private ReturnCode(final Integer returncode, final String message) {
        this.code = returncode;
        this.msg = message;
    }

    public static ReturnCode buildReturnCode(ReturnCode returnCode, String message){

        if(StringUtils.isEmpty(message)) return returnCode;

        return new ReturnCode(returnCode.getCode(),message);

    }

}
