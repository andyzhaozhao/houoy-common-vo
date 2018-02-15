package com.houoy.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class PageResultVO extends RequestResultVO {
    //冗余字段,分页
    @ApiModelProperty(value = "分页，从第多少条开始",hidden = false)
    private Integer start;

    @ApiModelProperty(value = "分页，长度（取多少行）",hidden = false)
    private Integer length;

    @ApiModelProperty(value = "分页，排序列名称）",hidden = false)
    private String orderColumnName;

    @ApiModelProperty(value = "分页，排序方法asc desc）",hidden = false)
    private String orderDir;

    @ApiModelProperty(value = "分页，总共有多少条数据）",hidden = false)
    private Long total;

    @Override
    public Map<String, Object> toMapValue() {
        Map<String, Object> map = super.toMapValue();
        map.put("start",start);
        map.put("length",length);
        map.put("orderColumnName",orderColumnName);
        map.put("orderDir",orderDir);
        map.put("total",total);

        return map;
    }
}
