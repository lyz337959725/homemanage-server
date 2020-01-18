package com.lyz.home.controller;

import com.lyz.home.entity.resp.RespEntity;
import com.lyz.home.entity.resp.statistics.FinanceByMonthResp;
import com.lyz.home.entity.resp.statistics.FinanceByTypeResp;
import com.lyz.home.service.FinanceStatisticsService;
import com.lyz.home.util.ResposeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statistics/finace")
@CrossOrigin()
public class FinanceStatisticsController {

    @Autowired
    private FinanceStatisticsService financeStatisticsService;

    @GetMapping("/month/{id}")
    public RespEntity statisticsBookByMonth(@PathVariable("id") int bookId){
        List<FinanceByMonthResp> list = financeStatisticsService.statisticsBookByMonth(bookId);
        return ResposeUtil.successWithData("",list);
    }

    @GetMapping("/person/{id}")
    public RespEntity statisticsBookByPerson(@PathVariable("id") int bookId){
        List<FinanceByTypeResp> list = financeStatisticsService.statisticsBookByPerson(bookId);
        return ResposeUtil.successWithData("",list);
    }

    @GetMapping("/type/{id}/{type}")
    public RespEntity statisticsBookByType(@PathVariable("id") int bookId,@PathVariable("type") int income){
        List<FinanceByTypeResp> list = financeStatisticsService.statisticsBookByType(bookId, income);
        return ResposeUtil.successWithData("",list);
    }
}
