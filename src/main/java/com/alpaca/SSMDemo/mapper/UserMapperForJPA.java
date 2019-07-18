package com.alpaca.SSMDemo.mapper;

import com.alpaca.SSMDemo.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: daixueyun
 * @Description:
 * @Date: Create in 22:08 2019/7/17
 */
public interface UserMapperForJPA {

    @Select("select * from users")
    @Results({
            @Result(property = "userName", column = "user_name"),
            @Result(property = "advantage", column = "advantage")
    })
    List<UserEntity> findAll();

    @Select("select * from users where id = #{id}")
    @Results({
            @Result(property = "userName", column = "user_name"),
            @Result(property = "advantage", column = "advantage")
    })
    UserEntity findOneById(Integer id);

    @Update("update users set user_name = #{userName},advantage = #{advantage} where id = #{id}")
    int updateUser(UserEntity userEntity);

    @Insert("insert into users(user_name, advantage) values(#{userName}, #{advantage})")
    int insertUser(UserEntity userEntity);

    @Delete("delete from users where id = #{id}")
    int deleteUser(Integer id);
}
