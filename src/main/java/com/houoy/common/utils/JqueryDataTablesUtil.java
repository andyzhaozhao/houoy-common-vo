package com.houoy.common.utils;

import com.houoy.common.vo.JquryDataTablesVO;
import com.houoy.common.vo.SuperVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author andyzhao
 */
public class JqueryDataTablesUtil {
    /**
     * 过滤传递过来的参数
     *
     * @param vo
     * @param request
     */
    public static SuperVO filterParam(SuperVO vo, HttpServletRequest request) {
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderColumnName = request.getParameter("columns[" + orderColumnIndex + "][data]");
        String orderDir = request.getParameter("order[0][dir]");
        vo.setOrderColumnName(orderColumnName);
        vo.setOrderDir(orderDir);
        return vo;
    }

    /**
     * datatables表格返回数据
     *
     * @param count
     * @param result
     * @return
     */
    public static JquryDataTablesVO<SuperVO> madeJqueryDatatablesVO(Long count, List result) {
        JquryDataTablesVO<SuperVO> rtv = new JquryDataTablesVO<SuperVO>();
        rtv.setRecordsTotal(count);
        rtv.setRecordsFiltered(count);
        rtv.setData(result);
        return rtv;
    }
}
