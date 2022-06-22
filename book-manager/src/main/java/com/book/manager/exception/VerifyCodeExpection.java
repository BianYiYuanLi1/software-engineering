package com.book.manager.exception;
import org.springframework.security.core.AuthenticationException;

/**
 * 自定义验证码异常类
 */
public class VerifyCodeExpection extends AuthenticationException {
    public VerifyCodeExpection(String msg, Throwable t) {
        super(msg, t);
    }

    public VerifyCodeExpection(String msg) {
        super(msg);
    }
}