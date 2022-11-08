package com.platform.backend.service.impl;

import com.platform.backend.entity.AppCategory;
import com.platform.backend.mapper.AppCategoryMapper;
import com.platform.backend.service.AppCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lenovo
 * @description 针对表【t_app_category(手游类别)】的数据库操作Service实现
 * @createDate 2022-10-31 10:37:04
 */
@Service
public class AppCategoryServiceImpl implements AppCategoryService {

    @Resource
    private AppCategoryMapper appCategoryMapper;


    @Override
    public List<AppCategory> queryAppCategoryListByLevels(String[] levels) {
        return appCategoryMapper.selectAppCategoryListByLevels(levels);
    }

    @Override
    public List<AppCategory> queryAppCategoryListByParentId(Long parentId) {
        return appCategoryMapper.selectAppCategoryListByParentId(parentId);
    }
}




