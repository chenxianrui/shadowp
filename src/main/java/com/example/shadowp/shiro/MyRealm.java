package com.example.shadowp.shiro;

import com.example.shadowp.project.user.dao.User;
import com.example.shadowp.project.user.mapper.GetTenantIdMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @Author aquarius_cxr
 * @Date 2020/8/4 22:44
 */
public class MyRealm extends AuthorizingRealm {

    @Resource
    private GetTenantIdMapper getTenantIdMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("doGetAuthorizationInfo");
        //获取前端输入的用户名
        String name = (String) principalCollection.getPrimaryPrincipal();
        //在数据库中获取该用户名的信息
        User user = getTenantIdMapper.selectByUserName(name);
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole(user.getRoleName());
        simpleAuthorizationInfo.addStringPermission(user.getPermission());
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        System.out.println("doGetAuthenticationInfo");
        //获取用户信息
        String name = authenticationToken.getPrincipal().toString();
        User user = getTenantIdMapper.selectByUserName(name);
        if (user == null) {
            //这里返回后会报出对应异常
            return null;
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, user.getPassWord(), getName());
            return simpleAuthenticationInfo;
        }

    }
}
