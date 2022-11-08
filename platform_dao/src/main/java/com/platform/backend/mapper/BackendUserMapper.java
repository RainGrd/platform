package com.platform.backend.mapper;

import com.platform.backend.entity.BackendUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BackendUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_backend_user
     *
     * @mbggenerated Sat Oct 29 11:15:54 CST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_backend_user
     *
     * @mbggenerated Sat Oct 29 11:15:54 CST 2022
     */
    int insert(BackendUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_backend_user
     *
     * @mbggenerated Sat Oct 29 11:15:54 CST 2022
     */
    int insertSelective(BackendUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_backend_user
     *
     * @mbggenerated Sat Oct 29 11:15:54 CST 2022
     */
    BackendUser selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_backend_user
     *
     * @mbggenerated Sat Oct 29 11:15:54 CST 2022
     */
    int updateByPrimaryKeySelective(BackendUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_backend_user
     *
     * @mbggenerated Sat Oct 29 11:15:54 CST 2022
     */
    int updateByPrimaryKey(BackendUser record);

    /**
     * 管理登录方法
     *
     * @param userName 用户名
     * @param password 密码
     * @return com.beyondPlatform.backend.entity.BackendUser
     */
    BackendUser backEndUserLogin(@Param("userCode") String userCode, @Param("password") String password);
}