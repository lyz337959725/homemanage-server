package com.lyz.home.controller;

import com.lyz.home.entity.db.Bill;
import com.lyz.home.entity.req.BillDto;
import com.lyz.home.entity.resp.BillResp;
import com.lyz.home.entity.resp.RespEntity;
import com.lyz.home.entity.resp.RespPageEntity;
import com.lyz.home.service.BillService;
import com.lyz.home.util.ResposeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bill")
@CrossOrigin()
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping("/{id}")
    public RespEntity getBill(@PathVariable("id") int id){
        Optional<Bill> optionalBill = billService.getBill(id);
        if(optionalBill.isPresent()){
            return ResposeUtil.successWithData("",optionalBill.get());
        }else{
            return ResposeUtil.error("获取原始数据失败");
        }
    }

    @PostMapping("/bills")
    public RespEntity getBillsByQuery(@RequestBody  BillDto queryData){
        RespPageEntity respPage = billService.getBillsByBookId(queryData);
        return ResposeUtil.successWithData("", respPage);
    }

    @PostMapping
    public RespEntity addBill(@RequestBody Bill bill){
        System.out.println(bill.toString());
        Bill saveBill = billService.addBill(bill);
        return ResposeUtil.successWithData("新增成功",saveBill);
    }

    @DeleteMapping("/{id}")
    public RespEntity deleteBill(@PathVariable("id") int id){
        billService.deleteBill(id);
        return ResposeUtil.success("删除成功");
    }
}
