package com.houoy.common.service;



import com.houoy.common.vo.SuperVO;

import java.util.List;

/**
 * Created by andyzhao on 2017/4/30.
 */
public interface BaseService<T extends SuperVO> {

    List<T> retrieveAll();

    List<T> retrieveByPK(String pk);

    Long retrieveAllCount() throws RuntimeException;

    List<T> retrieveAllWithPage(T vo) throws RuntimeException;

    Integer saveByVO(T vo);

    Integer updateByVO(T vo);

    Integer deleteByPK(String pk);

    Integer deleteByPK(List<String> pks);

    List<T> retrieveByParentPK(List<String> pks);
}
