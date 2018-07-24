package com.thinkive.demo.service.impl;

import com.thinkive.demo.dao.UserDao;
import com.thinkive.demo.pojo.User;
import com.thinkive.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public User getUserById(int userId) {
		return this.userDao.selectByPrimaryKey(userId);
	}

    @Override
    public User insertUser(User user) {
        userDao.insertSelective(user);
        return user;
    }

    @Override
    public void deleteUserById(Integer id) {
        userDao.deleteByPrimaryKey(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User updateUser(User user) {
        System.out.println(user);
        userDao.updateByPrimaryKeySelective(user);
        return user;
    }

}
