package com.zy.bk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zy.bk.entity.Tag;
import com.zy.bk.entity.page.Result;
import com.zy.bk.entity.page.TagVo;
import com.zy.bk.mapper.TagMapperMybatisPlus;
import com.zy.bk.service.TagServiceMybatisPlus;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TagServiceImplMybatisPlus extends ServiceImpl<TagMapperMybatisPlus, Tag> implements TagServiceMybatisPlus {
    @Autowired
    private TagMapperMybatisPlus tagMapperMybatisPlus;

    public TagVo copy(Tag tag){
        TagVo tagVo = new TagVo();
        BeanUtils.copyProperties(tag,tagVo);
        tagVo.setId(String.valueOf(tag.getId()));
        return tagVo;
    }
    public List<TagVo> copyList(List<Tag> tagList){
        List<TagVo> tagVoList = new ArrayList<>();
        for (Tag tag : tagList) {
            tagVoList.add(copy(tag));
        }
        return tagVoList;
    }
    @Override
    public List<TagVo> findTagsByArticleId(Long articleId) {
        //mybatisplus 无法进行多表查询
        List<Tag> tags = tagMapperMybatisPlus.findTagsByArticleId(articleId);
        return copyList(tags);
    }


}
