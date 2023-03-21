package com.zy.bk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zy.bk.common.contants.Contants;
import com.zy.bk.common.domain.ReturnObject;
import com.zy.bk.common.utils.DateUtils;
import com.zy.bk.entity.Article;
import com.zy.bk.entity.SysUser;
import com.zy.bk.entity.page.Archives;
import com.zy.bk.entity.page.ArticleVo;
import com.zy.bk.entity.page.PageParams;
import com.zy.bk.entity.page.TagVo;
import com.zy.bk.mapper.ArticleMapperMybatisPlus;
import com.zy.bk.service.ArticleServiceMybatisPlus;
import com.zy.bk.service.SysUserServiceMybatisPlus;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ArticleServiceMybatisPlusImpl extends ServiceImpl<ArticleMapperMybatisPlus, Article> implements ArticleServiceMybatisPlus {
    @Autowired
    ArticleMapperMybatisPlus articleMapperMybatisPlus;

    @Autowired
    SysUserServiceImplMybatisPlusImp sysUserServiceImplMybatisPlusImp;

    @Autowired
    TagServiceImplMybatisPlus tagServiceImplMybatisPlus;

    @Autowired
    private RedisTemplate redisTemplate;


    public ReturnObject listArticlesPage(PageParams pageParams, boolean isAuthor, boolean isTags) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        Page<Article> page = new Page<>(pageParams.getPage(), pageParams.getPageSize());
        Page<Article> articlePage = articleMapperMybatisPlus.selectPage(page, queryWrapper);
        List<ArticleVo> articleVoList = new ArrayList<>();
        for (Article article : articlePage.getRecords()) {
            ArticleVo articleVo = new ArticleVo();
            BeanUtils.copyProperties(article, articleVo);
            if (isAuthor) {
                SysUser sysUser = sysUserServiceImplMybatisPlusImp.findUserVoById(article.getAuthorId());
                articleVo.setAuthor(sysUser.getNickname());
            }
            articleVo.setCreateDate(new DateTime(article.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
            if (isTags) {
                List<TagVo> tags = tagServiceImplMybatisPlus.findTagsByArticleId(article.getId());
                articleVo.setTags(tags);
            }
            articleVoList.add(articleVo);
        }

        ReturnObject returnObject = new ReturnObject();
        returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
        returnObject.setSuccess(true);
        returnObject.setMessage("查询成功");
        returnObject.setData(articleVoList);

        return returnObject;
    }


    @Override
    public Object selectHottestArticleService(int page,int pageSize) {
        Page<Article> pageinfo = new Page<>(page,pageSize);
        LambdaQueryWrapper<Article> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.orderByDesc(Article::getViewCounts);

        Page<Article> articlePage =  articleMapperMybatisPlus.selectPage(pageinfo,lambdaQueryWrapper);

        List<ArticleVo> articleVoList = new ArrayList<>();
        List<Article> list = articlePage.getRecords();

        for(Article articlelist : list){
            ArticleVo articleVo = new ArticleVo();
            BeanUtils.copyProperties(articlelist,articleVo);
            articleVoList.add(articleVo);
        }

        ReturnObject returnObject = new ReturnObject();
        returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
        returnObject.setMessage("查询成功");
        returnObject.setData(articleVoList);
        returnObject.setSuccess(true);
        return returnObject;
    }


    @Override
    public Object selectLatestArticles(int page, int pageSize) {
        Page<Article> pageinfo = new Page<>(page,pageSize);
        LambdaQueryWrapper<Article> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.orderByDesc(Article::getCreateDate);

        Page<Article> articlePage =  articleMapperMybatisPlus.selectPage(pageinfo,lambdaQueryWrapper);

        List<ArticleVo> articleVoList = new ArrayList<>();
        List<Article> list = articlePage.getRecords();

        for(Article articlelist : list){
            ArticleVo articleVo = new ArticleVo();
            BeanUtils.copyProperties(articlelist,articleVo);
            articleVoList.add(articleVo);
        }

        ReturnObject returnObject = new ReturnObject();
        returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
        returnObject.setMessage("查询成功");
        returnObject.setData(articleVoList);
        returnObject.setSuccess(true);
        return returnObject;
    }


}
