package com.thinkive.demo.handler;

import com.thinkive.demo.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理类
 * @author yyt
 * @date 2018/3/21
 * @email yangyt@thinkive.com
 */
@ControllerAdvice
public class BaseExceptionHandler {

    /**
     * 统一处理异常类
     * @param request:请求
     * @param response:返回
     * @param ex:发生的异常
     * @return:返回的处理信息
     */
    @ExceptionHandler
    @ResponseBody
    public Map<String, Object>  handleAndReturnData(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        Map<String, Object> data = new HashMap<String, Object>();
        if(ex instanceof MyException) {
            MyException e = (MyException)ex;
            data.put("code", e.getCode());
        }
        data.put("msg", ex.getMessage());
        data.put("success", false);
        data.put("data", null);
        return data;
    }
}
