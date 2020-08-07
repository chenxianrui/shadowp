package com.example.shadowp.frame.handle;

import com.example.shadowp.frame.constants.MessageConstant;
import com.example.shadowp.frame.core.Result;
import com.example.shadowp.frame.core.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author aquarius_cxr
 * @Date 2020/8/4 21:24
 */
@ControllerAdvice
@Slf4j
public class MyExceptionHandler {

    @ExceptionHandler
    public String ErrorHandler(AuthorizationException e) {
        //无权限
        return "my_error";
//        return ResultGenerator.genFailResult(MessageConstant.NO_PERMISSIONS);
    }
}
