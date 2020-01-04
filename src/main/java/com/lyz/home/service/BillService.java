package com.lyz.home.service;

import com.lyz.home.entity.db.Bill;
import com.lyz.home.entity.req.BillDto;
import com.lyz.home.entity.resp.BillResp;
import com.lyz.home.entity.resp.RespPageEntity;
import com.lyz.home.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    public Optional<Bill> getBill(int id){
        return billRepository.findById(id);
    }

    public RespPageEntity getBillsByBookId(BillDto queryData){
        PageRequest page = PageRequest.of(queryData.getPage(), queryData.getSize(), Sort.by(Sort.Direction.DESC,"spend_date"));
        Page<Object[]> pageList = billRepository.findAll(
                queryData.getBook(), queryData.getType(), queryData.getPerson(), queryData.getWord(), page
        );
        List<BillResp> billList = new ArrayList<>();
        pageList.getContent().forEach(obj -> billList.add(
                BillResp.builder()
                        .spend(new BigDecimal(obj[0].toString()))
                        .spendDate(obj[1].toString())
                        .personName(obj[2].toString())
                        .typeName(obj[3].toString())
                        .id(Integer.parseInt(obj[4].toString()))
                        .content(obj[5].toString())
                        .income(Boolean.valueOf(obj[6].toString()))
                        .build()));
        return RespPageEntity.builder().total(pageList.getTotalElements()).data(billList).build();
    }

    public Bill addBill(Bill bill){
        return billRepository.save(bill);
    }

    public void deleteBill(int id){
        billRepository.deleteById(id);
    }
}
