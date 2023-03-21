package com.zy.bk.controller;

import com.zy.bk.entity.SysUser;
import com.zy.bk.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private SysUserService sysUserService;

    @PostMapping
    public Object selectLogin(@RequestBody SysUser sysUser){
        return sysUserService.selectLoginService(sysUser);
    }

}
