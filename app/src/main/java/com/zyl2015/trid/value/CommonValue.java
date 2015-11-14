package com.zyl2015.trid.value;

/**
 * 用于存放一些常量
 * Created by zyl on 2015/10/25.
 */
public class CommonValue {
    public static final int STATE_SUCCESS=100;
    public static final int STATE_ERROR=102;
    //HTTP请求URL:验证码请求
    public static final String URL_SMS_VALIDATION_REQUEST="http://101.200.89.240/" +
            "index.php?r=user/sms-validation-request";
    //HTTP请求URL:验证码登陆
    public static final String URL_SMS_VALIDATION_CODE="http://101.200.89.240/" +
            "index.php?r=user/sms-validation-code";
    //HTTP请求类型:验证码请求
    public static final String TYPE_SMS_VALIDATION_REQUEST="sms_validation_request";
    //HTTP请求类型:验证码登陆
    public static final String TYPE_SMS_VALIDATION_CODE="sms_validation_code";
    //HTTP返回类型:请求验证
    public static final String TYPE_SMS_VALIDATION_SEND="sms_validation_send";
    //HTTP返回类型:登录验证
    public static final String TYPE_SMS_VALIDATION_RESULT="sms_validation_result";
    //HTTP返回类型:好友列表请求
    public static final String TYPE_FRIEND_LIST_RESULT = "friend_list";
    //HTTP返回类型:历史会话
    public static final String TYPE_ALL_HISTORY_RESULT = "get_chat_record_result";
}
