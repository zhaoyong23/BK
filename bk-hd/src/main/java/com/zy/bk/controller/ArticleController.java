package com.zy.bk.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.bk.common.contants.Contants;
import com.zy.bk.common.domain.ReturnObject;
import com.zy.bk.entity.Article;
import com.zy.bk.entity.page.Archives;
import com.zy.bk.entity.page.PageParams;
import com.zy.bk.service.ArticleService;
import com.zy.bk.service.ArticleServiceMybatisPlus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    ArticleServiceMybatisPlus articleServiceMybatisPlus;

    @Autowired
    ArticleService articleService;

    /**
     * 实现首页文章分页
     * @param pageParams
     * @param isAuthor
     * @param isTags
     * @return
     */
    @PostMapping
    public Object selectArticle(PageParams pageParams,boolean isAuthor, boolean isTags){
        return articleServiceMybatisPlus.listArticlesPage(pageParams,isAuthor,isTags);
    }


    /**
     * 查询最热文章
     * @return
     */
    @PostMapping("/hot")
    public Object selectHottestArticle(){
        int page = 0;
        int pageSize = 3;
        return articleServiceMybatisPlus.selectHottestArticleService(page,pageSize);
    }


    /**
     * 查询最新文章
     * @return
     */
    @PostMapping("/new")
    public Object selectLatestArticles(){
        int page = 0;
        int pageSize = 3;
        return articleServiceMybatisPlus.selectLatestArticles(page,pageSize);
    }


    /**
     * 查询文章归档
     */
    @PostMapping("/listArchives")
    public ReturnObject selectArticleArchiving(){
        ReturnObject returnObject = new ReturnObject();
        List<Archives> r = articleService.selectArchives();
        returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
        returnObject.setMessage("查询成功");
        returnObject.setData(r);
        returnObject.setSuccess(true);
        return returnObject;
    }


}
