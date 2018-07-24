package com.thinkive.demo.exception;

import lombok.Getter;

/**
 * 自定义异常类
 * @author yyt
 * @date 2018/3/21
 * @email yangyt@thinkive.com
 */
@Getter
public class MyException extends RuntimeException {
    private Integer code;
    public MyException(String msg,Integer code){
        super(msg);
        this.code=code;
    }

}
