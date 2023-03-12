package com.zy.bk.service;



import com.zy.bk.entity.page.TagVo;

import java.util.List;

public interface TagServiceMybatisPlus {

    List<TagVo> findTagsByArticleId(Long articleId);



}
