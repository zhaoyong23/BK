package com.zy.bk.mapper;

import com.zy.bk.entity.MsArticle;

public interface MsArticleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_article
     *
     * @mbggenerated Fri Mar 03 10:24:15 CST 2023
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_article
     *
     * @mbggenerated Fri Mar 03 10:24:15 CST 2023
     */
    int insert(MsArticle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_article
     *
     * @mbggenerated Fri Mar 03 10:24:15 CST 2023
     */
    int insertSelective(MsArticle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_article
     *
     * @mbggenerated Fri Mar 03 10:24:15 CST 2023
     */
    MsArticle selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_article
     *
     * @mbggenerated Fri Mar 03 10:24:15 CST 2023
     */
    int updateByPrimaryKeySelective(MsArticle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_article
     *
     * @mbggenerated Fri Mar 03 10:24:15 CST 2023
     */
    int updateByPrimaryKey(MsArticle record);
}