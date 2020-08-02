package com.example.shadowp.project.user.controller;

import com.example.shadowp.constants.MessageConstant;
import com.example.shadowp.context.MyContext;
import com.example.shadowp.core.Result;
import com.example.shadowp.core.ResultGenerator;
import com.example.shadowp.project.user.dao.User;
import com.example.shadowp.project.user.service.GetTenantIdServiceImpl;
import com.example.shadowp.project.user.service.UserServiceImpl;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author aquarius_cxr
 * @Date 2020/7/24 21:29
 */
@RestController
@RequestMapping("/shadow")
public class GetTenantIdController {

    @Resource
    private MyContext myContext;

    @Resource
    private GetTenantIdServiceImpl getTenantIdService;

    @Resource
    private UserServiceImpl userService;

    /**
     * 登录接口
     * @param userName
     * @param passWord
     * @return
     */
    @PostMapping("/login/{userName}/{passWord}")
    public Result login(@PathVariable("userName") String userName, @PathVariable("passWord") String passWord){
        List<User> users = getTenantIdService.selectByUserName(userName);
        if (users == null) {
            // 如果user为空，则说明用户名或者密码不正确
            return ResultGenerator.genFailResult(MessageConstant.LOGIN_MESSAGE);
        } else {
            if(!users.get(0).getPassWord().equals(passWord))
                return ResultGenerator.genFailResult(MessageConstant.LOGIN_MESSAGE);
            // 登录成功，存取租户id
            Long tenantId = users.get(0).getTenantId();
            myContext.setCurrentTenantId(tenantId);
            return ResultGenerator.genSuccessResult(users);
        }
    }

    //生成账号密码
    @PostMapping("/produce")
    public Result produce(@RequestParam(value = "userName",required = false) String userName){
        List<User> users = getTenantIdService.selectByUserName(userName);
        User user = null;
        if (users.size() != 0){
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
