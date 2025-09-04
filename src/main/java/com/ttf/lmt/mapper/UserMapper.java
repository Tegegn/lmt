package com.ttf.lmt.mapper;

import com.ttf.lmt.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    User getUserById(@Param("id") Long userId);

    List<User> getAllUsers();
}
