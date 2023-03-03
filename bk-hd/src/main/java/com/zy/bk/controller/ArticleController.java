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
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleServiceMybatisPlus articleServiceMybatisPlus;


    @PostMapping
    public Object selectArticle(int page,int pageSize,String name){
        ReturnObject returnObject = new ReturnObject();
        log.info("开始查询---------------------------------");
        //分页构造器
        Page<Article> pageInfo = new Page<>(page,pageSize);
        //条件构造器
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //添加排序条件，根据sort进行排序
        //queryWrapper.orderByAsc(Article::getSort);

        Object e = articleServiceMybatisPlus.page(pageInfo,queryWrapper);
        returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
        returnObject.setMessage("查询成功");
        returnObject.setData(e);
        return returnObject;
    }
}
