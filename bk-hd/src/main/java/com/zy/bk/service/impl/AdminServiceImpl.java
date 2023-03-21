package com.zy.bk.service.impl;

import com.zy.bk.common.contants.Contants;
import com.zy.bk.common.domain.ReturnObject;
import com.zy.bk.entity.Admin;
import com.zy.bk.entity.SysUser;
import com.zy.bk.entity.page.AdminDto;
import com.zy.bk.mapper.AdminMapper;
import com.zy.bk.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private RedisTemplate redisTemplate;






}
