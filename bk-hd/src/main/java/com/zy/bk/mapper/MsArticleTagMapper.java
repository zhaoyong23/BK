package com.zy.bk.mapper;

import com.zy.bk.entity.MsArticleTag;

public interface MsArticleTagMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_article_tag
     *
     * @mbggenerated Fri Mar 03 10:25:35 CST 2023
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_article_tag
     *
     * @mbggenerated Fri Mar 03 10:25:35 CST 2023
     */
    int insert(MsArticleTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_article_tag
     *
     * @mbggenerated Fri Mar 03 10:25:35 CST 2023
     */
    int insertSelective(MsArticleTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_article_tag
     *
     * @mbggenerated Fri Mar 03 10:25:35 CST 2023
     */
    MsArticleTag selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_article_tag
     *
     * @mbggenerated Fri Mar 03 10:25:35 CST 2023
     */
    int updateByPrimaryKeySelective(MsArticleTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_article_tag
     *
     * @mbggenerated Fri Mar 03 10:25:35 CST 2023
     */
    int updateByPrimaryKey(MsArticleTag record);
}