package com.houoy.common.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author andyzhao
 */
@Data
@NoArgsConstructor
public abstract class SuperVO implements Serializable{

    private String memo;

    private String def1;
    private String def2;
    private String def3;
    private String def4;
    private String def5;

    private Boolean be_std;
    private String ts;
    private Integer dr;

    //冗余字段,分页
    //从第多少条开始
    private Integer start;

    // 取多少条
    private Integer length;

    //排序列名称
    private String orderColumnName;

    //排序方法asc desc
    private String orderDir;

    public abstract String getPKField() ;

    public abstract String getTableName();

    public abstract Object getPKValue();
}
