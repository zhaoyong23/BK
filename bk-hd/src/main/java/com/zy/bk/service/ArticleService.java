package com.zy.bk.service;

import com.zy.bk.entity.Article;
import com.zy.bk.entity.page.Archives;

import java.util.List;

public interface ArticleService {

    List<Archives> selectArchives();
}
