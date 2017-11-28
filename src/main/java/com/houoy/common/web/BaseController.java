package com.houoy.common.web;

import com.houoy.common.service.BaseService;
import com.houoy.common.utils.JqueryDataTablesUtil;
import com.houoy.common.vo.JquryDataTablesVO;
import com.houoy.common.vo.PageResultVO;
import com.houoy.common.vo.RequestResultVO;
import com.houoy.common.vo.SuperVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by andyzhao on 2017/9/12.
 */
public abstract class BaseController<V extends SuperVO, S extends BaseService> {

    protected S service;

    protected abstract void setService(S service);//为service赋值

    public RequestResultVO add(@RequestBody V vo) {
        Integer num = 0;
        RequestResultVO resultVO = new RequestResultVO();
        if (vo != null) {
            if (vo.getPKValue() != null) {//如果前端传递过来pk,则判断为更新操作
                num = service.updateByVO(vo);
            } else {
                num = service.saveByVO(vo);
            }

            if (num >= 1) {
                resultVO.setSuccess(true);
                resultVO.setMsg("保存成功");
                resultVO.setResultData(num);
            } else {
                resultVO.setSuccess(false);
                resultVO.setMsg("保存失败");
            }
        } else {
            resultVO.setSuccess(false);
            resultVO.setMsg("参数不可为null");
        }
        return resultVO;
    }

    public RequestResultVO delete(@RequestBody List<String> pks) {
        Integer num = service.deleteByPK(pks);
        RequestResultVO resultVO = new RequestResultVO();
        if (num >= 1) {
            resultVO.setSuccess(true);
            resultVO.setMsg("查询成功");
            resultVO.setResultData(num);
        } else {
            resultVO.setSuccess(false);
            resultVO.setMsg("保存");
        }

        return resultVO;
    }

    public JquryDataTablesVO<V> retrieve(V vo, HttpServletRequest request) {
        vo = (V) JqueryDataTablesUtil.filterParam(vo, request);
        List<V> result = service.retrieveAllWithPage(vo);
        Long count = service.retrieveAllCount(vo);
        JquryDataTablesVO rtv = JqueryDataTablesUtil.madeJqueryDatatablesVO(count, result);
        return rtv;
    }

    public PageResultVO retrieveMobile(V vo, HttpServletRequest request) {
        List<V> result = service.retrieveAllWithPage(vo);
        Long count = service.retrieveAllCount(vo);
        PageResultVO pageResultVO = new PageResultVO();
        pageResultVO.setSuccess(true);
        pageResultVO.setMsg("查询成功");
        pageResultVO.setResultData(result);
        pageResultVO.setStart(vo.getStart());
        pageResultVO.setLength(vo.getLength());
        pageResultVO.setOrderColumnName(vo.getOrderColumnName());
        pageResultVO.setOrderDir(vo.getOrderDir());
        pageResultVO.setTotal(count + "");
        return pageResultVO;
    }
}
