package com.pan.demo.service;

/**
 * @author EVA
 */
public interface UserService {

    String login(String id,String password);

    String getUserName(String userId);

    String register(String name, String password ,String email);

    String getUserIdByName(String userName);

    String getUserIdByEmail(String userName);
}
