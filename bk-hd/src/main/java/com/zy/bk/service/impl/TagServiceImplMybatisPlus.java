package com.zy.bk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zy.bk.common.contants.Contants;
import com.zy.bk.common.domain.ReturnObject;
import com.zy.bk.entity.Tag;
import com.zy.bk.entity.page.PageParams;
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
        tagVo.setId(tag.getId());
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


    @Override
    public ReturnObject selectTag(PageParams pageParams) {
        Page<Tag> page = new Page<>(pageParams.getPage(),pageParams.getPageSize());
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Tag::getId);

        Page<Tag> tagPage =  tagMapperMybatisPlus.selectPage(page,queryWrapper);

        List<TagVo> tagVoList = new ArrayList<>();

        List<Tag> tagList = tagPage.getRecords();
        for(Tag tag:tagList){
            TagVo tagVo = new TagVo();
            BeanUtils.copyProperties(tag,tagVo);

            tagVoList.add(tagVo);
        }

        ReturnObject returnObject = new ReturnObject();
        returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
        returnObject.setMessage("查询成功");
        returnObject.setData(tagVoList);
        returnObject.setSuccess(true);

        return returnObject;
    }
}
