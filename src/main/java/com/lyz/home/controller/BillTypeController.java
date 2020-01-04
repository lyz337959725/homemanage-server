package com.lyz.home.controller;

import com.lyz.home.entity.db.BillType;
import com.lyz.home.entity.resp.RespEntity;
import com.lyz.home.service.BillTypeService;
import com.lyz.home.util.ResposeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bill/type")
@CrossOrigin()
public class BillTypeController {

    @Autowired
    private BillTypeService billTypeService;

    @GetMapping
    public RespEntity getAllType(){
        List<BillType> list = billTypeService.getAllTypes();
        list.forEach(billType -> {
            if (billType.getParentId() != -1){
                list.forEach(type -> {
                    if(billType.getParentId() == type.getId()){
                        if(type.getChildren() == null){
                            type.setChildren(new ArrayList<>());
                        }
                        type.getChildren().add(billType);
                    }
                });
            }
        });
        list.removeIf(type -> type.getParentId() != -1);
        return ResposeUtil.successWithData("",list);
    }

    @PostMapping
    public RespEntity addType(@RequestBody BillType addType){
        BillType type = billTypeService.addOrUpdateBillType(addType);
        return ResposeUtil.successWithData("新增成功",type);
    }

    @PutMapping
    public RespEntity updateType(@RequestBody BillType addType){
        BillType type = billTypeService.addOrUpdateBillType(addType);
        return ResposeUtil.successWithData("修改成功",type);
    }

    @DeleteMapping("/{ids}")
    public RespEntity deleteType(@PathVariable("ids") String ids){
        System.out.println(ids);
        String[] strs = ids.split("-");
        int[] id = new int[strs.length];
        for (int i=0;i<id.length;i++) {
            id[i] = Integer.parseInt(strs[i]);
        }
        billTypeService.deleteBillType(id );
        return ResposeUtil.success("删除成功");
    }
}
