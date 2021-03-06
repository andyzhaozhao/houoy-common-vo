package com.houoy.common.service;

import com.houoy.common.mapper.BaseMapper;
import com.houoy.common.vo.SuperVO;

import java.util.List;

/**
 * Created by andyzhao on 2017/9/12.
 */
public abstract class BaseServiceImpl<M extends BaseMapper, T extends SuperVO> implements BaseService<T> {

    protected M mapper;

    protected abstract void setService(M _mapper);//为service赋值

    @Override
    public List<T> retrieveAll() {
        return mapper.retrieveAll();
    }

    @Override
    public List<T> retrieveByPK(String pk) {
        return mapper.retrieveByPK(pk);
    }

    @Override
    public Long retrieveAllCount(T vo) throws RuntimeException {
        return mapper.retrieveAllCount(vo);
    }

    @Override
    public List<T> retrieveAllWithPage(T vo) throws RuntimeException {
        return mapper.retrieveAllWithPage(vo);
    }

    @Override
    public Integer saveByVO(T vo) {
        return mapper.saveByVO(vo);
    }

    @Override
    public Integer updateByVO(T vo) {
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
    public List<T> retrieveByParentPK(List pks) {
        return mapper.retrieveByParentPK(pks);
    }
}
