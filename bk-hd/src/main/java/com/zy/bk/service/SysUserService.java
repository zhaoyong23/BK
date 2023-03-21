package com.zy.bk.service;

import com.zy.bk.common.domain.ReturnObject;
import com.zy.bk.entity.SysUser;

public interface SysUserService {

    ReturnObject selectLoginService(SysUser sysUser);


    /**
     * 查询用户信息
     * @param id
     * @return
     */
    SysUser selectgetUser(String id);



    /**
     * 用户注册
     * @param sysUser
     * @return
     */
    int insertUserService(SysUser sysUser);
}
