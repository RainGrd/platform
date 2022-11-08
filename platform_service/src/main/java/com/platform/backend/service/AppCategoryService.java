package com.platform.backend.service;

import com.platform.backend.entity.AppCategory;

import java.util.List;

/**
 * @author lenovo
 * @description 针对表【t_app_category(手游类别)】的数据库操作Service
 * @createDate 2022-10-31 10:37:04
 */
public interface AppCategoryService {

    /**
     * 根据等级数组查询应用分类级别列表
     *
     * @return
     */
    List<AppCategory> queryAppCategoryListByLevels(String[] levels);

    /**
     * 根据分类父级节点id来查询
     * @param parentId
     * @return
     */
    List<AppCategory> queryAppCategoryListByParentId(Long parentId);
}
