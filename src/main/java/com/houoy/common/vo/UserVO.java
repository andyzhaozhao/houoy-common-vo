package com.houoy.common.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by andyzhao on 2017/10/11.
 */
@Data
@NoArgsConstructor
public class UserVO implements Serializable {
    public static String USERCODE = "user_code";
    public static String PASSWORD = "user_password";

    public static String Default_PassWord = "1";

    protected String pk_user;
    protected String pk_role;
    protected String user_code;
    protected String user_name;
    protected String user_password;
    protected String email;
    protected String mobile;
    protected String be_locked;
    protected Timestamp abletime;
    protected Timestamp disabletime;

    //----------------------------------
    //冗余字段
    //----------------------------------
    protected Boolean be_enterprise;
    protected Boolean be_me;
    protected Boolean be_operation;
    protected Boolean be_console;
    protected Boolean be_actived;
    protected String locked_reason;
    protected Timestamp reg_ts;
    protected Timestamp last_login_ts;
    protected String encrypted_password;
    protected String avatar_url;

    //冗余字段,分页
    //从第多少条开始
    private Integer start;

    // 取多少条
    private Integer length;

    //排序列名称
    private String orderColumnName;

    //排序方法asc desc
    private String orderDir;
}