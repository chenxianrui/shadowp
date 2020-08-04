package com.example.shadowp.project.user.mapper;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shadowp.project.user.dao.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author aquarius_cxr
 * @Date 2020/7/24 21:52
 */
public interface GetTenantIdMapper extends BaseMapper<User> {

    // 这里可以放一些公共的方法

    /**
     * 根据用户名查询
     * @param userName 用户名
     * @return  用户对象
     */
    @SqlParser(filter = true)
    @Select("select * from user where user_name = #{userName};")
    User selectByUserName(String userName);
}
