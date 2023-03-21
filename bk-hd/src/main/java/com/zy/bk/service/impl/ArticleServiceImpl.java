package com.zy.bk.service.impl;

import com.zy.bk.entity.page.Archives;
import com.zy.bk.mapper.ArticleMapper;
import com.zy.bk.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;


    @Override
    public List<Archives> selectArchives() {
        return articleMapper.listartchives();
    }
}
