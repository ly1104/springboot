package com.yjxxt.controller;

import com.github.pagehelper.PageInfo;
import com.yjxxt.bean.User;
import com.yjxxt.exception.ParamException;
import com.yjxxt.query.UserQuery;
import com.yjxxt.service.UserService;
import com.yjxxt.utils.ResultInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "根据用户id查询用户记录")
    @ApiImplicitParam(name = "userId",value = "查询参数",required = true,paramType = "path")
    @GetMapping("user/id/{id}")
    @ResponseBody
    public User findId(Integer id){
        User user = userService.findUserById(id);
        return user;
    }


    @ApiOperation(value = "根据用户名查询用户记录")
    @ApiImplicitParam(name = "userName",value = "查询参数",required = true,paramType = "path")
    @RequestMapping("findUser/{name}")
    @ResponseBody
    public ResultInfo index(@PathVariable(name = "name") String userName){
        ResultInfo resultInfo = new ResultInfo();

        return resultInfo;
    }



    @ApiOperation(value = "多条件查询用户列表记录")
    @RequestMapping("list")
    @ResponseBody
    public PageInfo<User> sayPage(UserQuery userQuery){
        //查询分页后的集合数据
        PageInfo<User> plist = userService.selectUserByParam(userQuery);
        //
        return plist;
    }


    @ApiOperation(value = "用户添加")
    @ApiImplicitParam(name = "user",value = "用户实体类",dataType = "User")
    @PostMapping("add")
    @ResponseBody
    public ResultInfo sayAdd(User user){
        ResultInfo resultInfo = new ResultInfo();
        //try {
            userService.addUser(user);
            resultInfo.setResult(user);
        /*}catch (ParamException px){
            px.printStackTrace();
            resultInfo.setCode(px.getCode());
            resultInfo.setMsg(px.getMsg());
        }catch (Exception ex){
            ex.printStackTrace();
            resultInfo.setMsg(ex.getMessage());
        }*/
        return resultInfo;
    }



    @ApiOperation(value = "用户更新")
    @ApiImplicitParam(name = "user",value = "用户实体类",dataType = "User")
    @PutMapping("update")
    @ResponseBody
    public ResultInfo sayUpdate(User user){
        ResultInfo resultInfo = new ResultInfo();
        //try {
            userService.changeUser(user);
            resultInfo.setCode(200);
            resultInfo.setMsg("修改成功了");
       /* }catch (ParamException px){
            px.printStackTrace();
            resultInfo.setCode(px.getCode());
            resultInfo.setMsg(px.getMsg());
        }catch (Exception ex){
            ex.printStackTrace();
            resultInfo.setCode(300);
            resultInfo.setMsg(ex.getMessage());
        }*/
        return resultInfo;
    }

    @ApiOperation(value = "根据用户id删除用户记录")
    @ApiImplicitParam(name = "userId",value = "查询参数",required = true,paramType = "path")
    @DeleteMapping("del/{id}")
    @ResponseBody
    public ResultInfo sayDel(@PathVariable("id") Integer id){
        ResultInfo resultInfo = new ResultInfo();
        //try {
            userService.removeUserById(id);
            resultInfo.setCode(200);
            resultInfo.setMsg("删除成功了");
        /*}catch (ParamException px){
            px.printStackTrace();
            resultInfo.setCode(px.getCode());
            resultInfo.setMsg(px.getMsg());
        }catch (Exception ex){
            ex.printStackTrace();
            resultInfo.setCode(300);
            resultInfo.setMsg(ex.getMessage());
        }*/
        return resultInfo;
    }

}
