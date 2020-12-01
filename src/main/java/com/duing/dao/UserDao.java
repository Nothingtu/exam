package com.duing.dao;

import com.duing.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    @Select("select id,name,password from user where id = #{id}")
    User selectOne(Integer id);
}
