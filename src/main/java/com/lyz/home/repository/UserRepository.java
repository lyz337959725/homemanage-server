package com.lyz.home.repository;

import com.lyz.home.entity.db.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

    User findByName(String name);

    User findByOpenid(String openid);

    List<User> findAll();


}
