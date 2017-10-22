package com.houoy.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by andyzhao on 2017/10/11.
 */
@Data
@NoArgsConstructor
public class UserVO extends SuperVO {
    @ApiModelProperty(hidden = true)
    public static String USERCODE = "user_code";
    @ApiModelProperty(hidden = true)
    public static String PASSWORD = "user_password";
    @ApiModelProperty(hidden = true)
    public static String Default_PassWord = "1";
    @ApiModelProperty(hidden = true)
    protected String pk_user;
    @ApiModelProperty(hidden = true)
    protected String pk_role;

    @ApiModelProperty(value = "用户编码",hidden = false)
    protected String user_code;
    @ApiModelProperty(value = "用户名称",hidden = false)
    protected String user_name;
    @ApiModelProperty(value = "用户密码",hidden = false)
    protected String user_password;
    @ApiModelProperty(value = "用户邮箱",hidden = false)
    protected String email;
    @ApiModelProperty(value = "用户手机号",hidden = false)
    protected String mobile;

    @ApiModelProperty(hidden = true)
    protected String be_locked;

    @ApiModelProperty(hidden = true)
    protected Timestamp abletime;
    @ApiModelProperty(hidden = true)
    protected Timestamp disabletime;

    //----------------------------------
    //冗余字段
    //----------------------------------
    @ApiModelProperty(hidden = true)
    protected Boolean be_enterprise;
    @ApiModelProperty(hidden = true)
    protected Boolean be_me;
    @ApiModelProperty(hidden = true)
    protected Boolean be_operation;
    @ApiModelProperty(hidden = true)
    protected Boolean be_console;
    @ApiModelProperty(hidden = true)
    protected Boolean be_actived;
    @ApiModelProperty(hidden = true)
    protected String locked_reason;
    @ApiModelProperty(hidden = true)
    protected Timestamp reg_ts;
    @ApiModelProperty(hidden = true)
    protected Timestamp last_login_ts;
    @ApiModelProperty(hidden = true)
    protected String encrypted_password;
    @ApiModelProperty(hidden = true)
    protected String avatar_url;

    @Override
    public String getPKField() {
        return "pk_user";
    }

    @Override
    public String getTableName() {
        return "sm_user";
    }

    @Override
    public Object getPKValue() {
        return pk_user;
    }
}