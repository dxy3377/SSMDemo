package com.alpaca.SSMDemo.mapper;

import com.alpaca.SSMDemo.entity.UserEntity;
import org.omg.CORBA.INTERNAL;

import java.util.List;

/**
 * Created by daixueyun on 2019/7/18 0018.
 */
public interface UserMapperForXML {

    List<UserEntity> findAll();

    UserEntity findOneById(Integer id);

    int updateUser(UserEntity userEntity);

    int insertUser(UserEntity userEntity);

    int deleteUser(Integer id);
}
