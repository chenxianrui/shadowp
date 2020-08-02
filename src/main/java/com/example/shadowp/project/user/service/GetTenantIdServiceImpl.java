package com.example.shadowp.project.user.service;

import com.example.shadowp.project.user.dao.User;
import com.example.shadowp.project.user.mapper.GetTenantIdMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author aquarius_cxr
 * @Date 2020/7/24 21:30
 */
@Service
public class GetTenantIdServiceImpl implements IGetTenantIdService{

    @Resource
    private GetTenantIdMapper getTenantIdMapper;

    /**
     * 根据用户名查询
     * @param userName 用户名
     * @return  用户对象
     */
    @Override
    public List<User> selectByUserName(String userName) {

//        List<User> users = getTenantIdMapper.selectByUserName(userName, passWord);

        return getTenantIdMapper.selectByUserName(userName);
    }
}
