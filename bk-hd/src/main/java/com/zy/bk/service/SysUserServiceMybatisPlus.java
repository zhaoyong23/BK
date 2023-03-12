package com.zy.bk.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zy.bk.entity.Article;
import com.zy.bk.entity.SysUser;
import com.zy.bk.entity.page.UserVo;

public interface SysUserServiceMybatisPlus extends IService<SysUser> {

    UserVo findUserVoById(Long id);

}
