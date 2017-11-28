package com.houoy.common.mapper;

import com.houoy.common.vo.SuperVO;

import java.util.List;

/**
 * @author andyzhao
 */
public interface BaseMapper<T extends SuperVO> {
    //select:单表
    List<T> retrieveByPK(String pk) throws RuntimeException;

    List<T> retrieveAll() throws RuntimeException;

    Long retrieveAllCount(T vo) throws RuntimeException;

    List<T> retrieveAllWithPage(T vo) throws RuntimeException;

    Integer saveByVO(T vo);

    Integer updateByVO(T vo);

    Integer deleteByPK(String pk);

    Integer deleteByPKs(List<String> pks);

    List<T> retrieveByParentPK(List<String> pks);
}
