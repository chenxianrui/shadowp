package com.example.shadowp.project.user.service;

import com.example.shadowp.project.user.dao.User;

import java.util.List;

/**
 * @Author aquarius_cxr
 * @Date 2020/7/24 22:00
 */
public interface IGetTenantIdService {

    /**
     * 根据用户名查询租户id
     * @param userName  用户名
     * @return
     */
    public User selectByUserName(String userName);

}
