package com.zy.bk.service;



import com.zy.bk.common.domain.ReturnObject;
import com.zy.bk.entity.page.PageParams;
import com.zy.bk.entity.page.TagVo;

import java.util.List;

public interface TagServiceMybatisPlus {

    List<TagVo> findTagsByArticleId(Long articleId);

    ReturnObject selectTag(PageParams pageParams);

}
