package com.example.shadowp.shiro;

import com.example.shadowp.project.user.dao.User;
import com.example.shadowp.project.user.mapper.GetTenantIdMapper;
import com.example.shadowp.project.user.mapper.UserMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author aquarius_cxr
 * @Date 2020/8/4 22:44
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private GetTenantIdMapper getTenantIdMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取前端输入的用户名
        String name = "";
        //在数据库中获取该用户名的信息
        User user = getTenantIdMapper.selectByUserName(name);
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();


        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
