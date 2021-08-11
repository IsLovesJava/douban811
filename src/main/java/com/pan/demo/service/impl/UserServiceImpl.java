package com.pan.demo.service.impl;

import com.pan.demo.mapper.UserMapper;
import com.pan.demo.model.User;
import com.pan.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author EVA
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    UserMapper userMapper;

    public UserServiceImpl() {
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public static String getNumberId(int length) {
        StringBuilder wait = new StringBuilder();
        StringBuilder id = new StringBuilder();
        int randomCount=100;
        for (int i = 0; i < randomCount; i++) {
            wait.append((int) (Math.random() * 10));
        }
        int start = (int) (Math.random() * 80);
        id.append(wait.subSequence(start, start + length));
        return id.toString();
    }

    public static String getId(int length) {
        String defaultChars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder wait = new StringBuilder();
        StringBuilder id = new StringBuilder();
        id.append((int) (Math.random() * 10));
        int randomCount=100;
        for (int i = 0; i < randomCount; i++) {
            wait.append(defaultChars.toCharArray()[(int) (Math.random() * 62)]);
        }
        int start = (int) (Math.random() * (int) (Math.random() * 80));
        id.append(wait.subSequence(start, start + length - 1));

        return id.toString();
    }

    @Override
    public String login(String input, String password) {

        String userId=userMapper.loginCheckName(input,password);
        if (userId==null){
            userId=userMapper.loginCheck(input,password);
        }
        return userId;
    }

    @Override
    public String getUserName(String userId) {
        return userMapper.selectUserName(userId);
    }

    @Override
    public String register(String name, String password,String email) {
        String userId=getNumberId(8);
        User user=new User();
        user.setID(userId);
        user.setUserName(name);
        user.setPassword(password);
        user.setEmail(email);
        String registerTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        user.setRegisterTime(registerTime);
        userMapper.insertUser(user);
        return userId;
    }

    @Override
    public String getUserIdByName(String userName) {

        return userMapper.selectUserIdByName(userName);
    }

    @Override
    public String getUserIdByEmail(String email) {
        return userMapper.selectUserIdByEmail(email);
    }
}
