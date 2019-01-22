package org.javemos.ssmcrud.dao;

import org.javemos.ssmcrud.pojo.BaseDict;

import java.util.List;

/**
 * @Description:
 */
public interface BaseDictDao {
    List<BaseDict> getDictListByTypeCode(String typeCode);
}
