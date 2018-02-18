package com.houoy.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author andyzhao
 */
@Data
@NoArgsConstructor
public abstract class SuperVO implements Serializable{

    @ApiModelProperty(hidden = true)
    private String memo;
    @ApiModelProperty(hidden = true)
    private String def1;
    @ApiModelProperty(hidden = true)
    private String def2;
    @ApiModelProperty(hidden = true)
    private String def3;
    @ApiModelProperty(hidden = true)
    private String def4;
    @ApiModelProperty(hidden = true)
    private String def5;
    @ApiModelProperty(hidden = true)
    private Boolean be_std;
    @ApiModelProperty(hidden = true)
    private String ts;
    @ApiModelProperty(hidden = true)
    private Integer dr;

    //冗余字段,分页
    @ApiModelProperty(value = "分页，从第多少条开始",hidden = false,example = "0")
    private Integer start = 0;

    @ApiModelProperty(value = "分页，长度（取多少行）",hidden = false,example = "10")
    private Integer length = 10;

    @ApiModelProperty(value = "分页，排序列名称）",hidden = false,example = "ts")
    private String orderColumnName = "ts";

    @ApiModelProperty(value = "分页，排序方法asc desc）",hidden = false,example = "desc")
    private String orderDir = "desc";

    @ApiModelProperty(hidden = true)
    public abstract String getPKField() ;
    @ApiModelProperty(hidden = true)
    public abstract String getTableName();
    @ApiModelProperty(hidden = true)
    public abstract Object getPKValue();
}
