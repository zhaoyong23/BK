package com.zy.bk.controller;

import com.zy.bk.common.contants.Contants;
import com.zy.bk.common.domain.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logout")
public class LogoutController {
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping
    public ReturnObject logOut(){
        ReturnObject returnObject = new ReturnObject();
        redisTemplate.delete(Contants.SESSION_USER);
        returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
        returnObject.setMessage("安全退出，已清除缓存");
        returnObject.setSuccess(true);
        return returnObject;
    }
}
