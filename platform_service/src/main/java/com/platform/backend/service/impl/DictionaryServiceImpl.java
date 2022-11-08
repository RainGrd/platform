package com.platform.backend.service.impl;

import com.platform.backend.entity.Dictionary;
import com.platform.backend.mapper.DictionaryMapper;
import com.platform.backend.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/31 9:11
 * FileName: DictionaryServiceImpl
 * Description: 字典业务实现类
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Resource
    private DictionaryMapper dictionaryMapper;

    @Override
    public Dictionary queryByValueId(Long valueId) {
        return dictionaryMapper.selectByValueId(valueId);
    }

    @Override
    public List<Dictionary> queryByTypeCodeDictionaryList(String typeCode) {
        return dictionaryMapper.selectByTypeCodeDictionaryList(typeCode);
    }
}
