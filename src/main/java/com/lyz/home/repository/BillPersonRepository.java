package com.lyz.home.repository;

import com.lyz.home.entity.db.BillPerson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillPersonRepository extends CrudRepository<BillPerson,Integer> {
}
