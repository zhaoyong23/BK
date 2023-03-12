package com.zy.bk.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.bk.common.contants.Contants;
import com.zy.bk.common.domain.ReturnObject;
import com.zy.bk.entity.Article;
import com.zy.bk.entity.page.PageParams;
import com.zy.bk.service.ArticleServiceMybatisPlus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    ArticleServiceMybatisPlus articleServiceMybatisPlus;


    @PostMapping
    public Object selectArticle(PageParams pageParams,boolean isAuthor, boolean isTags){
        return articleServiceMybatisPlus.listArticlesPage(pageParams,isAuthor,isTags);
    }
}
