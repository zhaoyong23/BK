package com.zy.bk.common.contants;

//常量类
public class Contants {

    //返回ReturnObject类的code值
    public static final Integer RETURN_OBJECT_CODE_SUCCESS = 200;//成功
    public static final Integer RETURN_OBJECT_CODE_FAIL = 404;//失败

    //保存当前用户的key
    public static final String SESSION_USER="sessionUser";

    //备注的修改标记
    public static final String REMARK_EDIT_FLAG_NO_EDITED="0";//0---没有修改过
    public static final String REMARK_EDIT_FLAG_YES_EDITED="1";//1--已经被修改过
}
