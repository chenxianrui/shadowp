package com.example.shadowp.project.user.service;

import com.example.shadowp.project.user.dao.User;
import com.example.shadowp.project.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author aquarius_cxr
 * @Date 2020/8/2 14:51
 */
@Service
public class UserServiceImpl implements IUserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public User addUser(String userName, String passWord) {
        //插入用户名与密码
        userMapper.addUser(userName, passWord);
        //获取id
        int id = userMapper.selectIdByUserName(userName);
        //增加租户id
        userMapper.addTenantId(id, id);

        User user = new User();
        user.setUserName(userName);
        user.setPassWord(passWord);

        return user;
    }
}
