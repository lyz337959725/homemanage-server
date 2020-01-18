package com.lyz.home.service;

import com.lyz.home.entity.resp.statistics.FinanceByMonthResp;
import com.lyz.home.entity.resp.statistics.FinanceByTypeResp;
import com.lyz.home.repository.BillRepository;
import com.lyz.home.util.ObjectConvertEntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceStatisticsService {

    @Autowired
    private BillRepository billRepository;

    public List<FinanceByMonthResp> statisticsBookByMonth(int bookId){
        List<Object[]> objList = billRepository.statisticsBookByMonth(bookId);
        try {
            return ObjectConvertEntityUtil.objectConvertEntity(objList,FinanceByMonthResp.class);
        } catch (Exception e) {
            return null;
        }
    }

    public List<FinanceByTypeResp> statisticsBookByPerson(int bookId){
        List<Object[]> objList = billRepository.statisticsBookByPerson(bookId);
        try {
            return ObjectConvertEntityUtil.objectConvertEntity(objList,FinanceByTypeResp.class);
        } catch (Exception e) {
            return null;
        }
    }

    public List<FinanceByTypeResp> statisticsBookByType(int bookId, int income){
        List<Object[]> objList = billRepository.statisticsBookByType(bookId,income);
        try {
            return ObjectConvertEntityUtil.objectConvertEntity(objList,FinanceByTypeResp.class);
        } catch (Exception e) {
            return null;
        }
    }

}
