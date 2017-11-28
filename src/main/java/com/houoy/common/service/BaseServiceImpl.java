package com.houoy.common.service;

import com.houoy.common.mapper.BaseMapper;
import com.houoy.common.vo.SuperVO;

import java.util.List;

/**
 * Created by andyzhao on 2017/9/12.
 */
public abstract class BaseServiceImpl<M extends BaseMapper, T extends SuperVO> implements BaseService {

    protected M mapper;

    protected abstract void setService(M _mapper);//为service赋值

    @Override
    public List retrieveAll() {
        return mapper.retrieveAll();
    }

    @Override
    public List retrieveByPK(String pk) {
        return mapper.retrieveByPK(pk);
    }

    @Override
    public Long retrieveAllCount(SuperVO vo) throws RuntimeException {
        return mapper.retrieveAllCount(vo);
    }

    @Override
    public List retrieveAllWithPage(SuperVO vo) throws RuntimeException {
        return mapper.retrieveAllWithPage(vo);
    }

    @Override
    public Integer saveByVO(SuperVO vo) {
        return mapper.saveByVO(vo);
    }

    @Override
    public Integer updateByVO(SuperVO vo) {
        return mapper.updateByVO(vo);
    }

    @Override
    public Integer deleteByPK(String pk) {
        return mapper.deleteByPK(pk);
    }

    @Override
    public Integer deleteByPK(List pks) {
        return mapper.deleteByPKs(pks);
    }

    @Override
    public List retrieveByParentPK(List pks) {
        return mapper.retrieveByParentPK(pks);
    }
}
