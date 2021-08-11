package com.pan.demo.mapper;

import com.pan.demo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select userName from web_user where ID=#{id}")
    String selectUserName(String id);

    @Select("select ID from web_user where ID=#{id} and password=#{password}")
    String loginCheck(String id,String password);

    @Insert("insert into web_user values(#{ID},#{userName},#{password},#{email},#{registerTime})")
    void insertUser(User user);

    @Select("select ID from web_user where userName=#{userName}")
    String selectUserIdByName(String userName);

    @Select("select ID from web_user where email=#{email}")
    String selectUserIdByEmail(String email);

    @Select("select ID from web_user where userName=#{input} and password=#{password}")
    String loginCheckName(String input, String password);
}
