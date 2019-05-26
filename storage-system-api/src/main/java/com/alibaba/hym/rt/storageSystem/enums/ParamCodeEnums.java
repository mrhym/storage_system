package com.alibaba.hym.rt.storageSystem.enums;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/1/30 19:13
 **/
public enum ParamCodeEnums {
    SUCCESS("200", "成功"),
    NULL_OBJ("LUO001", "对象为空"),
    PARA_ERROR("PA0100", "参数错误"),
    NULL_RESULT("RE0404", "结果为空"),
    ERROR("RE400", "操作失败"),
    ALREADY_OPERATED("RE300","已操作"),
    LOGIN_ERROR("RE302","登录失败"),
    UPLOAD_ERROR("RE303","上传失败"),
    TOKEN_ERROR("RE304","token错误"),
    SYSTEM_ERROR("RE301", "系统错误");


    private String msg;
    private String code;

    ParamCodeEnums(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getCode() {
        return this.code;
    }

}
