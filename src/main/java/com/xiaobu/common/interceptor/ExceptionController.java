package com.xiaobu.common.interceptor;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authz.UnauthorizedException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.xiaobu.common.base.BaseController;
import com.xiaobu.common.config.Code;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionController extends BaseController{


    // 捕捉 CustomRealm 抛出的异常
    @ExceptionHandler(AccountException.class)
    public Object handleShiroException(Exception ex) {
        return actionResult(Code.BAD_REQUEST,ex.getMessage());
    }

   /* @ExceptionHandler(ShiroException.class)
    public Object handle401() {
        return actionResult(Code.BAD_REQUEST,"您没有权限访问！");
    }*/

    // 捕捉shiro的异常
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public Object handle401(ShiroException e) {
        return  actionResult(Code.UNAUTHORIZED, "Token验证失败，请重新登录", null);
    }

    // 捕捉UnauthorizedException
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public Object handle401() {
        return actionResult(Code.UNAUTHORIZED, "Unauthorized", null);
    }

    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object globalException(HttpServletRequest request, Throwable ex) {
        return actionResult(null, getStatus(request), ex.getMessage());
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

}
