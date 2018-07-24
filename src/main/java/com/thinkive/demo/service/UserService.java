package com.thinkive.demo.service;


import com.thinkive.demo.pojo.User;

import java.util.List;

public interface UserService {
    /**
     * 根据用户Id获取用户信息
     * @param userId:用户Id
     * @return
     */
	User getUserById(int userId);

    /**
     * 插入用户信息
     * @param user:要插入的用户信息
     * @return
     */
	User insertUser(User user);

    /**
     * 删除用户,根据ID
     * @param id
     */
    void deleteUserById(Integer id);

    /**
     * 查询全部用户
     * @return:用户信息列表
     */
    List<User> findAll();

    /**
     * 更新用户信息
     * @param user:用户信息
     * @return:更新后的用户信息
     */
    User updateUser(User user);
}
