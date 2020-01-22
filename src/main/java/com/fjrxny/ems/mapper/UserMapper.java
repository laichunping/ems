package com.fjrxny.ems.mapper;

import com.fjrxny.ems.pojo.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    /**
     * 验证用户正确性
     * @param user
     * @return
     */
    User verifyUser(User user);
}
