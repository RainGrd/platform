package com.platform.backend.service;

import com.platform.backend.entity.Dictionary;

import java.util.List;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/31 9:10
 * FileName: Dictionary
 * Description: 字典表
 */
public interface DictionaryService {
    /**
     * 根据id查询字典
     */
    Dictionary queryByValueId(Long id);

    /**
     * 根据typeCode查询所包括的数据字典
     */
    List<Dictionary> queryByTypeCodeDictionaryList(String typeCode);


}
