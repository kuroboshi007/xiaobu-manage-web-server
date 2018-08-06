package com.xiaobu.common.interceptor;

import org.apache.shiro.authc.AccountException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.xiaobu.common.base.BaseController;
import com.xiaobu.common.config.Code;

@RestControllerAdvice
public class ExceptionController extends BaseController{


    // 捕捉 CustomRealm 抛出的异常
    @ExceptionHandler(AccountException.class)
    public Object handleShiroException(Exception ex) {
        return actionResult(Code.BAD_REQUEST,ex.getMessage());
    }
}
