package com.lyz.home.util;

import com.lyz.home.entity.resp.RespEntity;

public class ResposeUtil {

    public static RespEntity successWithData(String message,Object object){
        return RespEntity.builder().success(true).message(message).data(object).build();
    }

    public static RespEntity success(String message){
        return RespEntity.builder().success(true).message(message).build();
    }

    public static RespEntity error(String message){
        return RespEntity.builder().success(false).message(message).build();
    }

}
