package com.zy.bk.mapper;

import com.zy.bk.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_sys_user
     *
     * @mbggenerated Fri Mar 03 10:26:59 CST 2023
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_sys_user
     *
     * @mbggenerated Fri Mar 03 10:26:59 CST 2023
     */
    int insert(SysUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_sys_user
     *
     * @mbggenerated Fri Mar 03 10:26:59 CST 2023
     */
    int insertSelective(SysUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_sys_user
     *
     * @mbggenerated Fri Mar 03 10:26:59 CST 2023
     */
    SysUser selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_sys_user
     *
     * @mbggenerated Fri Mar 03 10:26:59 CST 2023
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_sys_user
     *
     * @mbggenerated Fri Mar 03 10:26:59 CST 2023
     */
    int updateByPrimaryKey(SysUser record);
}