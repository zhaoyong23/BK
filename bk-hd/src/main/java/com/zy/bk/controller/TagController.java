package com.zy.bk.controller;

import com.zy.bk.common.domain.ReturnObject;
import com.zy.bk.entity.page.PageParams;
import com.zy.bk.service.TagServiceMybatisPlus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    TagServiceMybatisPlus tagServiceMybatisPlus;

    @GetMapping("/hot")
    public Object selectTag(){
        PageParams pageParams = new PageParams();
        return tagServiceMybatisPlus.selectTag(pageParams);
    }

}
