package com.yjxxt.mapper;

import com.yjxxt.bean.User;
import com.yjxxt.query.UserQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserMapper {

    //根据id查询
    public User selectUserById(Integer id);

    //根据用户名查询
    public User selectUserByName(String userName);

    //分页条件查询
    public List<User> selectParams(UserQuery userQuery);


    //添加
    public int insertUser(User user);

    //删除
    public int deleteUserById(Integer id);

    //修改
    public int updateUser(User user);
}
