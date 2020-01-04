package com.lyz.home.controller;

import com.lyz.home.entity.db.User;
import com.lyz.home.entity.resp.RespEntity;
import com.lyz.home.service.UserService;
import com.lyz.home.util.ResposeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin()
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public RespEntity getAllUsers(){
        List<User> list = userService.getAllUsers();
        return ResposeUtil.successWithData("",list);
    }

    @PostMapping()
    public RespEntity addUser(@RequestBody User addUser){
        addUser.setPassword(DigestUtils.md5DigestAsHex(addUser.getPassword().getBytes()).toUpperCase());
        User user = userService.saveUser(addUser);
        return ResposeUtil.successWithData("新增成功",user);
    }

    @DeleteMapping("/{id}")
    public RespEntity deleteUser(@PathVariable("id") int userId){
        userService.deleteUser(userId);
        return ResposeUtil.success("删除成功");
    }
}
