package com.duing.service.impl;

import com.duing.dao.UserDao;
import com.duing.domain.User;
import com.duing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserDao userDao;

    //返回为true是表示用户信息验证成功 false表示用户名或密码错误
    @Override
    public boolean checkLogin(User user) {
        User resultUser = userDao.selectOne(user.getId());
        if(resultUser != null && user.equals(resultUser)) return true;
        return false;
    }
}
