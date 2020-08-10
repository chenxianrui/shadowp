package com.example.shadowp.project.user.controller;

import com.example.shadowp.frame.constants.MessageConstant;
import com.example.shadowp.frame.context.MyContext;
import com.example.shadowp.frame.core.Result;
import com.example.shadowp.frame.core.ResultGenerator;
import com.example.shadowp.project.user.dao.User;
import com.example.shadowp.project.user.service.impl.GetTenantIdServiceImpl;
import com.example.shadowp.project.user.service.impl.UserServiceImpl;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author aquarius_cxr
 * @Date 2020/7/24 21:29
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoginController {

    @Resource
    private MyContext myContext;

    @Resource
    private GetTenantIdServiceImpl getTenantIdService;

    @Resource
    private UserServiceImpl userService;

    @RequestMapping("/login")
    public Result login(User user) {
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUserName(), user.getPassWord());
        User users = null;
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
            // 登录成功，存取租户id
            users = getTenantIdService.selectByUserName(user.getUserName());
            Long tenantId = users.getTenantId();
            myContext.setCurrentTenantId(tenantId);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult(MessageConstant.LOGIN_MESSAGE);
        } catch (AuthorizationException e) {
            e.printStackTrace();

            return ResultGenerator.genFailResult(MessageConstant.NO_PERMISSIONS);
        }
        return ResultGenerator.genSuccessResult(users);

    }

    @RequiresRoles("admin")
    @RequiresPermissions("add")
    @RequestMapping("/product")
    public Result product(@RequestParam(value = "userName",required = false) String userName) {
        User users = getTenantIdService.selectByUserName(userName);
        User user = null;
        if (users != null){
            //用户已经存在
            return ResultGenerator.genFailResult(MessageConstant.USERNAME_IS_USED);
        }
        //生成随机密码
        String passWord = RandomStringUtils.randomAlphanumeric(10);
        try {
            user = userService.addUser(userName, passWord);
        }catch (Exception e){
            e.printStackTrace();
        }

        return ResultGenerator.genSuccessResult(user);
    }
}
