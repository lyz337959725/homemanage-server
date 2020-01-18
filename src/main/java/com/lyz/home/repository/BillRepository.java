package com.lyz.home.repository;

import com.lyz.home.entity.db.Bill;
import com.lyz.home.entity.req.BillDto;
import com.lyz.home.entity.resp.statistics.FinanceByMonthResp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Query(nativeQuery = true,
            value = "select date_format(create_date, '%m') as months, sum(if(is_income=0,spend,0)) spendAmount," +
                    "sum(if(is_income=1,spend,0)) incomeAmount " +
                    "from bill " +
                    "where book_id = ?1 " +
                    "group by months")
    List<Object[]> statisticsBookByMonth(int bookId);

    @Query(nativeQuery = true,
            value = "select bp.name,sum(b.spend) from bill b " +
                    "INNER JOIN bill_person bp on bp.id = b.person_id " +
                    "where b.is_income = 0 and b.book_id = ?1 GROUP BY bp.name")
    List<Object[]> statisticsBookByPerson(int bookId);


    @Query(nativeQuery = true,
            value ="select bt2.name,sum(bp.spend) from  " +
                    "(select bt.parent_id,b.spend from bill b " +
                    "INNER JOIN bill_type bt on bt.id = b.type_id where b.is_income = ?2 and b.book_id = ?1) bp " +
                    "INNER JOIN bill_type bt2 on bt2.id = bp.parent_id group by bt2.name")
    List<Object[]> statisticsBookByType(int bookId, int income);
}
