package com.zy.bk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zy.bk.entity.Tag;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface TagMapperMybatisPlus extends BaseMapper<Tag> {
    /**
     * 根据文章id查询标签列表
     * @param articleId
     * @return
     */
    List<Tag> findTagsByArticleId(Long articleId);

}
