package com.lyz.home.controller;

import com.lyz.home.entity.db.BillPerson;
import com.lyz.home.entity.resp.RespEntity;
import com.lyz.home.service.BillPersonService;
import com.lyz.home.util.ResposeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill/person")
@CrossOrigin()
public class BillPersonController {

    @Autowired
    private BillPersonService billPersonService;

    @GetMapping()
    public RespEntity getAllPerson(){
        List<BillPerson> list = billPersonService.getAllPersons();
        return ResposeUtil.successWithData("",list);
    }

    @PostMapping
    public RespEntity addPerson(@RequestBody BillPerson Person){
        BillPerson billPerson = billPersonService.addAndUpdatePerson(Person);
        return ResposeUtil.successWithData("新增成功",billPerson);
    }

    @PutMapping
    public RespEntity updatePerson(@RequestBody BillPerson Person){
        BillPerson billPerson = billPersonService.addAndUpdatePerson(Person);
        return ResposeUtil.successWithData("修改成功",billPerson);
    }

    @DeleteMapping("/{id}")
    public RespEntity deletePerson(@PathVariable("id") int id){
        billPersonService.deletePerson(id);
        return ResposeUtil.success("删除成功");
    }
}
