package com.example.shadowp.project.user.service;

import com.example.shadowp.project.user.dao.User;

/**
 * @Author aquarius_cxr
 * @Date 2020/8/2 14:53
 */
public interface IUserService {

    public User addUser(String userName, String passWord);
}
