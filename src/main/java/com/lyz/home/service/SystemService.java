package com.lyz.home.service;

import com.lyz.home.entity.db.User;
import com.lyz.home.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByName(String name){
        return userRepository.findByName(name);
    }


}
