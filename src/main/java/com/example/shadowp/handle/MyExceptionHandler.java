package com.example.shadowp.handle;

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
        return "my_error";
    }
}
