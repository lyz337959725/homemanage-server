package com.lyz.home.service;

import com.lyz.home.entity.db.BillType;
import com.lyz.home.repository.BillTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BillTypeService {

    @Autowired
    private BillTypeRepository billTypeRepository;

    public List<BillType> getAllTypes(){
        return billTypeRepository.findAllByOrderBySortAsc();
    }

    public BillType addOrUpdateBillType(BillType type){
        return billTypeRepository.save(type);
    }

    public void deleteBillType(int[] ids){
        billTypeRepository.deleteByIdIn(ids);
    }
}
