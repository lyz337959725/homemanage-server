package com.lyz.home.controller;

import com.lyz.home.entity.db.User;
import com.lyz.home.entity.resp.RespEntity;
import com.lyz.home.service.SystemService;
import com.lyz.home.service.UserService;
import com.lyz.home.util.JwtUtil;
import com.lyz.home.util.ResposeUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/sys")
@CrossOrigin()
public class SystemController {

    @Autowired
    private SystemService systemService;
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public RespEntity login(@RequestBody User loginUser){
        System.out.println(loginUser);
        User user = systemService.getUserByName(loginUser.getName());
        if(user == null){
            return ResposeUtil.error("用户不存在");
        }else{
            if(DigestUtils.md5DigestAsHex(loginUser.getPassword().getBytes()).toUpperCase().equals(user.getPassword())){
                return ResposeUtil.success(jwtUtil.createJwt(Integer.toString(user.getId())));
            }else{
                return ResposeUtil.error("密码错误");
            }
        }
    }

    @GetMapping("/profile")
    public String profile(HttpServletRequest request){
        String authorization = request.getHeader("Authorization");
        if(StringUtils.isEmpty(authorization)){
            return "";
        }
        String token = authorization.replace("Bearer ", "");
        Claims claims = jwtUtil.parseJwt(token);
        if(claims == null){
            return "";
        }
        Optional<User> user = userService.getUserById(Integer.parseInt(claims.getId()));
        if(user.isPresent()){
            return user.get().getName();
        }else {
            return "";
        }
    }
}
