package com.houoy.common.vo;

import java.io.Serializable;

public abstract class AbstractSessionBean implements ISessionBean,Serializable
{
    protected UserVO user;

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

    public String getSession_user_id()
    {
        if (user != null)
        {
            return user.getPk_user();
        }
        return null;
    }

    public String getSession_user_code() {
        if (user != null)
        {
            return user.getUser_code();
        }
        return null;
    }

    public String getSession_user_name() {
        if (user != null)
        {
            return user.getUser_name();
        }
        return null;
    }

    public String getSession_user_email() {
        if (user != null)
        {
            return user.getEmail();
        }
        return null;
    }

    public String getSession_user_mobile() {
        if (user != null)
        {
            return user.getMobile();
        }
        return null;
    }
}
