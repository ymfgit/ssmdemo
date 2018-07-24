package com.thinkive.demo.controller;

import com.thinkive.demo.exception.MyException;
import com.thinkive.demo.pojo.User;
import com.thinkive.demo.service.UserService;
import com.thinkive.demo.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * 用户控制Controller
 * @author yyt
 * @date 2018/3/21
 * @email yangyt@thinkive.com
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据用户Id获取到用户信息
     * @param id:用户ID
     * @return:用户信息
     */
    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        return user;
    }


    /**
     * 保存用户信息
     * @param user:用户信息
     * @return:插入的用户信息
     */
    @ResponseBody
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public User insertUser(User user){
        user=userService.insertUser(user);
        return user;
    }

    /**
     * 删除用户信息,根据Id
     * @param id:用户id
     */
    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    public void deleteUserById(@PathVariable Integer id){
        userService.deleteUserById(id);
    }

    /**
     * 查询全部用户信息
     * @return:用户信息列表
     */
    @ResponseBody
    @RequestMapping(value = "/findAll",method = RequestMethod.POST)
    public List<User> findAll(){
        List<User> users =userService.findAll();
        return users;
    }

    /**
     * 更新用户信息
     * @param user:更新的用户信息
     * @return:更新后的用户信息
     */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public User updateUser(User user){
        return userService.updateUser(user);
    }

    /**
     * 测试全局异常拦截
     * @return
     */
    @RequestMapping("/exception")
    public String exception(){
        throw new MyException("exception拦截",1);
    }


    /**
     * 展示Jstl标签显示用户信息
     * @param session:session存取用户信息
     * @return:跳转的页面地址
     */
    @RequestMapping("/showAll")
    public String showUserInfo(HttpSession session){
        List<User> userList=userService.findAll();
        session.setAttribute(Constants.SESSION_KEY_USER_INFO,userList);
        return "showUser";
    }
}
