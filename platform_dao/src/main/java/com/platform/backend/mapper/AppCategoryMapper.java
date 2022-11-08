package com.platform.backend.mapper;

import com.platform.backend.entity.AppCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lenovo
 * @description 针对表【t_app_category(手游类别)】的数据库操作Mapper
 * @createDate 2022-10-31 10:37:04
 * @Entity com.platform.backend.entity.AppCategory
 */
public interface AppCategoryMapper {
    /**
     * 根据应用等级数组查询应用等级
     *
     * @return
     */
    List<AppCategory> selectAppCategoryListByLevels(@Param("levels") String[] levels);

    /**
     * 根据分类父级节点id来查询
     * @param parentId
     * @return
     */
    List<AppCategory> selectAppCategoryListByParentId(@Param("parentId") Long parentId);
}




