package com.zy.bk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zy.bk.entity.Article;
import com.zy.bk.entity.page.ArticleVo;
import com.zy.bk.entity.page.PageParams;

import java.util.List;

public interface ArticleServiceMybatisPlus extends IService<Article> {

    Object listArticlesPage(PageParams pageParams,boolean isAuthor, boolean isTags);
}
