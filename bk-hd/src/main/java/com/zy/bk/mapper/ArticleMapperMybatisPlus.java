package com.zy.bk.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.bk.entity.Article;
import com.zy.bk.entity.page.Archives;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapperMybatisPlus extends BaseMapper<Article> {

    IPage<Article> listArticle(Page<Article> page,
                               LambdaQueryWrapper<Article> lambdaQueryWrapper,
                               Long categoryId,
                               Long tagId,
                               String year,
                               String month);
}
