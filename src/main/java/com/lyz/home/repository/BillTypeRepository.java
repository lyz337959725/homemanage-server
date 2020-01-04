package com.lyz.home.repository;

import com.lyz.home.entity.db.BillType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BillTypeRepository extends CrudRepository<BillType,Integer> {

    @Transactional
    void deleteByIdIn(int[] ids);
}
