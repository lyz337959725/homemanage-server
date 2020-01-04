package com.lyz.home.repository;

import com.lyz.home.entity.db.BillBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillBookRepository  extends CrudRepository<BillBook,Integer> {
}
