package com.zy.bk.controller;

import com.zy.bk.common.contants.Contants;
import com.zy.bk.common.domain.ReturnObject;
import com.zy.bk.entity.SysUser;
import com.zy.bk.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/currentUser")
    public ReturnObject selectgetUser(){
        //根据缓存里的id查用户信息
        String id = (String) redisTemplate.opsForValue().get(Contants.SESSION_USER);

        ReturnObject returnObject = new ReturnObject();
        SysUser sysUser = sysUserService.selectgetUser(id);
        returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
        returnObject.setMessage("查询成功");
        returnObject.setData(sysUser);
        returnObject.setSuccess(true);
        return returnObject;
    }


}
