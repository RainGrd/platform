package com.platform.developer.mapper;

import com.platform.developer.entity.DevUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* @author lenovo
* @description 针对表【t_dev_user】的数据库操作Mapper
* @createDate 2022-11-06 19:24:53
* @Entity com.platform.developer.entity.DevUser
*/
public interface DevUserMapper {
    /**
     * 登录方法
     * @param devCode
     * @param devPassword
     * @return
     */
    DevUser login(@Param("devCode") String devCode,@Param("devPassword") String devPassword);
}




