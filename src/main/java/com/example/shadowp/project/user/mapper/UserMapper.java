package com.example.shadowp.project.user.mapper;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shadowp.project.user.dao.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @Author aquarius_cxr
 * @Date 2020/8/1 13:02
 */
public interface UserMapper extends BaseMapper<User> {

    // 这里可以放一些公共的方法

    /**
     * 通过用户名查询id
     * @param userName
     * @return
     */
    @SqlParser(filter = true)
    @Select("select id from user where user_name = #{userName};")
    int selectIdByUserName(@Param("userName") String userName);

    /**
     * 新增用户与密码
     * @param userName
     * @param passWord
     * @return
     */
    @SqlParser(filter = true)
    @Insert("insert into user (user_name, pass_word) values(#{userName}, #{passWord});")
    int addUser(@Param("userName") String userName, @Param("passWord") String passWord);

    /**
     * 增加租户id，与id相同
     * @param userName
     * @param passWord
     * @return
     */
    @SqlParser(filter = true)
    @Update("update user set tenant_id = #{tenantId} where id = #{id};")
    int addTenantId(@Param("tenantId") int tenantId, @Param("id") int id);
}
