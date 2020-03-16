package com.lyz.home.controller;

import com.lyz.home.entity.req.WxAuthDto;
import com.lyz.home.entity.resp.RespEntity;
import com.lyz.home.util.ResposeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wx")
@CrossOrigin()
public class WxController {

    @Autowired
    private WxAuthDto auth;

    @GetMapping("/auth")
    public RespEntity getOpenId(@RequestParam("code") String code){
        auth.setJs_code(code);
        return ResposeUtil.successWithData("",auth);
    }


}
