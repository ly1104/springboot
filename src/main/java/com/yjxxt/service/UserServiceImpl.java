package com.yjxxt.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yjxxt.bean.User;
import com.yjxxt.mapper.UserMapper;
import com.yjxxt.query.UserQuery;
import com.yjxxt.utils.AssignUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;



    @Override
    //@Cacheable(value = "users",key = "#id")
    public User findUserById(Integer id) {
        //抛出异常
        AssignUtil.isTrue(true,"异常测试");
        return userMapper.selectUserById(id) ;

    }

    @Override
    public User findUserByName(String userName) {
        return userMapper.selectUserByName(userName);
    }

    @Override
    public PageInfo<User> selectUserByParam(UserQuery userQuery) {
        //初始化分页查询
        PageHelper.startPage(userQuery.getPageNum(),userQuery.getPageSize());
        //查询所有记录
        List<User> ulist = userMapper.selectParams(userQuery);
        //开始分页
        PageInfo<User> plist = new PageInfo<>(ulist);
        System.out.println(plist.getTotal());
        System.out.println(plist.isHasNextPage());
        System.out.println(plist.isHasPreviousPage());
        System.out.println(plist.isIsFirstPage());
        System.out.println(plist.isIsLastPage());
        System.out.println(plist.getPageNum());
        System.out.println(plist.getPages());
        System.out.println(plist.getList());
        //返回分页后的集合对象
        return plist;
    }

    @Override
    public void addUser(User user) {
        //用户名不能为空
        AssignUtil.isTrue(StringUtils.isBlank(user.getUserName()),"用户名不能为空");
        //密码不能为空
        AssignUtil.isTrue(StringUtils.isBlank(user.getUserPwd()),"密码不能为空");
        //用户名已经存在
        //查询
        User temp = userMapper.selectUserByName(user.getUserName());
        AssignUtil.isTrue(temp!=null,"用户名已经存在");
        //添加是否成功
        AssignUtil.isTrue(userMapper.insertUser(user)<1,"添加失败了");
    }



    @Override
    public void removeUserById(Integer id) {
        AssignUtil.isTrue(userMapper.selectUserById(id)==null||id==null,"待删除记录不存在");
        AssignUtil.isTrue(userMapper.deleteUserById(id)<1,"删除失败了");

    }

    @Override
    public void changeUser(User user) {
        //用户名不能为空
        AssignUtil.isTrue(StringUtils.isBlank(user.getUserName()),"用户名不能为空");
        //密码不能为空
        AssignUtil.isTrue(StringUtils.isBlank(user.getUserPwd()),"密码不能为空");
        //用户名已经存在
        /*User temp = userMapper.selectUserById(user.getId());
        AssignUtil.isTrue(temp==null,"用户不存在");*/
        User user1 = userMapper.selectUserByName(user.getUserName());
        AssignUtil.isTrue(user1!=null&&!(user1.getId().equals(user.getId())),"用户已存在");
        //修改判断
        AssignUtil.isTrue(userMapper.updateUser(user)<1,"修改失败了");
    }
}














