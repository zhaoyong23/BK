package com.zy.bk.entity.page;

import com.zy.bk.entity.SysUser;
import lombok.Data;

@Data
public class UserVo extends SysUser {

    private String nickname;

    private String avatar;

    private Long id;
}
