package com.zy.bk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zy.bk.common.domain.ReturnObject;
import com.zy.bk.entity.Article;
import com.zy.bk.entity.page.Archives;
import com.zy.bk.entity.page.ArticleVo;
import com.zy.bk.entity.page.PageParams;

import java.util.List;

public interface ArticleServiceMybatisPlus extends IService<Article> {

    /**
     * 实现首页文章分页
     * @param pageParams
     * @param isAuthor
     * @param isTags
     * @return
     */
    Object listArticlesPage(PageParams pageParams,boolean isAuthor, boolean isTags);


    /**
     * 查询最热文章
     * @param page
     * @param pageSize
     * @return
     */
    Object selectHottestArticleService(int page,int pageSize);


    /**
     * 查询最新文章
     * @param page
     * @param pageSize
     * @return
     */
    Object selectLatestArticles(int page,int pageSize);




}
