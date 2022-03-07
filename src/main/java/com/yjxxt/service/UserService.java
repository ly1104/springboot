package com.yjxxt.service;

import com.github.pagehelper.PageInfo;
import com.yjxxt.bean.User;
import com.yjxxt.query.UserQuery;

import java.util.List;

public interface UserService {
    //根据id查询
    public User findUserById(Integer id);

    //根据用户名查询
    public User findUserByName(String userName);

    //分页查询
    public PageInfo<User> selectUserByParam(UserQuery userQuery);

    //添加
    public void addUser(User user);

    //删除
    public void removeUserById(Integer id);

    //修改
    public void changeUser(User user);

}
