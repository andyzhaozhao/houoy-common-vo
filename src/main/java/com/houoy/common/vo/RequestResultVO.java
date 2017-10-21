package com.houoy.common.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class RequestResultVO implements Serializable {
    private static final long serialVersionUID = 5454372461726768872L;

    protected Boolean success;

    protected String msg;

    protected String detailMessage;

    protected String statusCode;

    protected String resultDataType;

    protected Object resultData;

    //用于上传文件使用
    protected String uploadId;

    protected Object def1;

    protected Object def2;

    protected Object def3;

    protected Object def4;

    protected Object def5;


    public RequestResultVO(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public Boolean getSuccess() {
        if (success == null) {
            success = false;
        }
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }


    public String getMsg() {
        if (msg == null) {
            msg = getSuccess().booleanValue() ? "数据处理成功！" : "数据处理失败！";
        }
        return msg;
    }

    public Map<String, Object> toMapValue() {
        Map<String, Object> map = new LinkedHashMap();

        map.put("success", getSuccess());
        map.put("msg", getMsg());
        map.put("detailMessage", detailMessage);
        map.put("statusCode", statusCode);
        map.put("resultDataType", resultDataType);
        map.put("resultData", resultData);
        map.put("uploadId", uploadId);
        map.put("def1", def1);
        map.put("def2", def2);
        map.put("def3", def3);
        map.put("def4", def4);
        map.put("def5", def5);

        return map;
    }
}
