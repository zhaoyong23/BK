package com.zy.bk.service.impl;

import com.zy.bk.common.contants.Contants;
import com.zy.bk.common.domain.ReturnObject;
import com.zy.bk.common.utils.DateUtils;
import com.zy.bk.entity.Admin;
import com.zy.bk.entity.SysUser;
import com.zy.bk.mapper.SysUserMapper;
import com.zy.bk.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private RedisTemplate redisTemplate;


    public ReturnObject selectLoginService(SysUser sysUser) {
        String password = sysUser.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        Map<String,String> map = new HashMap<>();
        map.put("account",sysUser.getAccount());
        map.put("password",password);
        SysUser adminLogin = sysUserMapper.selectLogin(map);

        ReturnObject returnObject = new ReturnObject();
        if (adminLogin == null){
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("登录失败");
            returnObject.setSuccess(false);
        }
        else if(!adminLogin.getPassword().equals(password)){
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("账户密码错误");
            returnObject.setSuccess(false);
        }
        else {
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("登录成功");
            returnObject.setSuccess(true);
            redisTemplate.opsForValue().set(Contants.SESSION_USER,String.valueOf(adminLogin.getId()));
        }
        return returnObject;
    }


    @Override
    public SysUser selectgetUser(String id) {
        return sysUserMapper.selectgetUser(id);
    }


    @Override
    public int insertUserService(SysUser sysUser) {
        String password = DigestUtils.md5DigestAsHex(sysUser.getPassword().getBytes());
        sysUser.setPassword(password);
        sysUser.setAvatar("/static/img/logo.b3a48c0.png");
        //sysUser.setCreateDate(Long.valueOf(DateUtils.formateDateTime(new Date())));
        sysUser.setDeleted(Boolean.valueOf("0"));
        return sysUserMapper.insertUser(sysUser);
    }
}
