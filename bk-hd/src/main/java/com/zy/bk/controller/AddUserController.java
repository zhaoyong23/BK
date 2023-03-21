package com.zy.bk.controller;

import com.zy.bk.common.contants.Contants;
import com.zy.bk.common.domain.ReturnObject;
import com.zy.bk.entity.SysUser;
import com.zy.bk.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class AddUserController {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 用户注册
     * @param sysUser
     * @return
     */
    @PostMapping
    public ReturnObject insertUser(@RequestBody SysUser sysUser){
        ReturnObject returnObject = new ReturnObject();
        try {
            sysUserService.insertUserService(sysUser);

            //获取注册用户id进行页面展示
            redisTemplate.opsForValue().set(Contants.SESSION_USER,String.valueOf(sysUser.getId()));

            returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("注册成功");
            returnObject.setSuccess(true);
        } catch (Exception e) {
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("注册失败");
            returnObject.setSuccess(false);
        }
        return returnObject;
    }


}
