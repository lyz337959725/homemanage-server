package com.lyz.home.util;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class ObjectConvertEntityUtil {

    public static <T> List<T> objectConvertEntity(List<Object[]> list, Class<T> clazz) throws Exception {
        if(list == null || list.isEmpty()){
            return null;
        }
        Class[] parameterTypes = null;
        Constructor<?>[] constructors = clazz.getConstructors();
        for(Constructor cons : constructors){
            Class[] types = cons.getParameterTypes();
            if(types.length == list.get(0).length){
                parameterTypes = types;
                break;
            }
        }
        List<T> entityList = new ArrayList<>();
        Constructor<T> constructor = clazz.getConstructor(parameterTypes);
        for(Object[] objs: list){
            entityList.add(constructor.newInstance(objs));
        }
        return entityList;
    }
}
