package com.example.demo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Result;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserDao {

    @Select("SELECT user_id,flag,phone,email,note" +
            " FROM t_user where user_id = #{id}")
    @Results({
            @Result(property = "user_id", column = "userId"),
            @Result(property = "flag", column = "flag"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "email", column = "email"),
            @Result(property = "note", column = "note")
    })
    User findById(@Param("id") int id);
}
