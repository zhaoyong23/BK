package com.zy.bk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zy.bk.entity.Article;
import com.zy.bk.entity.page.ArticleVo;
import com.zy.bk.entity.page.PageParams;
import com.zy.bk.mapper.ArticleMapperMybatisPlus;
import com.zy.bk.service.ArticleServiceMybatisPlus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ArticleServiceMybatisPlusImpl extends ServiceImpl<ArticleMapperMybatisPlus, Article> implements ArticleServiceMybatisPlus {
    @Autowired
    ArticleMapperMybatisPlus articleMapperMybatisPlus;



}
