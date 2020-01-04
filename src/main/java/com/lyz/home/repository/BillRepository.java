package com.lyz.home.repository;

import com.lyz.home.entity.db.Bill;
import com.lyz.home.entity.req.BillDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill,Integer>, JpaSpecificationExecutor {


    @Query(nativeQuery = true,
            value = "select b.spend,b.spend_date,bp.name personName,bt.name typeName,b.id,b.content,b.is_income" +
                    " from bill as b INNER JOIN bill_book bb ON b.book_id = bb.id " +
                    "INNER JOIN bill_person bp on b.person_id = bp.id " +
                    "INNER JOIN bill_type bt on b.type_id = bt.id " +
                    "where bb.id = ?1 and if(?2 != 0,bt.id = ?2,1=1) and " +
                    "if(?3 != 0,bp.id = ?3,1=1) and if(?4 != '',b.content like concat('%',?4,'%'),1=1) ",
            countQuery = "select count(b.id)" +
                    " from bill as b INNER JOIN bill_book bb ON b.book_id = bb.id " +
                    "INNER JOIN bill_person bp on b.person_id = bp.id " +
                    "INNER JOIN bill_type bt on b.type_id = bt.id " +
                    "where bb.id = ?1 and if(?2 != 0,bt.id = ?2,1=1) and " +
                    "if(?3 != 0,bp.id = ?3,1=1) and if(?4 != '',b.content like concat('%',?4,'%'),1=1) "
    )
    Page<Object[]> findAll(int bookId,int typeId,int personId, String word, Pageable pageable);
}
