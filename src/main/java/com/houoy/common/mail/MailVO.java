package com.houoy.common.mail;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

/**
 * User: andyzhao
 * Date: 2017/6/29
 * Time: 10:57
 */
@Data
@NoArgsConstructor
public class MailVO implements Serializable {

    @ApiModelProperty(value = "收件人", hidden = false)
    private String to;
    @ApiModelProperty(value = "标题", hidden = false)
    private String subject;
    @ApiModelProperty(value = "内容", hidden = false)
    private String content;
    @ApiModelProperty(hidden = true)
    private String from;
    @ApiModelProperty(hidden = true)
    private Map<String, Object> params;
}
