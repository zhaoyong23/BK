package com.zy.bk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zy.bk.entity.Article;
import com.zy.bk.entity.SysUser;
import com.zy.bk.entity.page.ErrorCode;
import com.zy.bk.entity.page.LoginUserVo;
import com.zy.bk.entity.page.Result;
import com.zy.bk.entity.page.UserVo;
import com.zy.bk.mapper.ArticleMapperMybatisPlus;
import com.zy.bk.mapper.SysUserMapperMybatisPlus;
import com.zy.bk.service.ArticleServiceMybatisPlus;
import com.zy.bk.service.SysUserServiceMybatisPlus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImplMybatisPlusImp extends ServiceImpl<SysUserMapperMybatisPlus, SysUser> implements SysUserServiceMybatisPlus {

    @Autowired
    private SysUserMapperMybatisPlus sysUserMapperMybatisPlus;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    @Override
    public UserVo findUserVoById(Long id) {
        SysUser sysUser = sysUserMapperMybatisPlus.selectById(id);
        if (sysUser == null){
            sysUser = new SysUser();
            sysUser.setId(1L);
            sysUser.setAvatar("/static/img/logo.b3a48c0.png");
            sysUser.setNickname("码神之路");
        }
        UserVo userVo  = new UserVo();
        BeanUtils.copyProperties(sysUser,userVo);
        userVo.setId(sysUser.getId());
        return userVo;
    }


}
