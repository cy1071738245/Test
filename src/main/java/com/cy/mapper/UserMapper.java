package com.cy.mapper;

import com.cy.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    int register(@Param("userName") String userName, @Param("password") String password, @Param("realName") String realName);

    User login(@Param("userName") String userName, @Param("password") String password);

}
