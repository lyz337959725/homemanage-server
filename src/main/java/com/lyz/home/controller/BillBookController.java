package com.lyz.home.controller;

import com.lyz.home.entity.db.BillBook;
import com.lyz.home.entity.resp.RespEntity;
import com.lyz.home.service.BillBookService;
import com.lyz.home.util.ResposeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill/book")
@CrossOrigin()
public class BillBookController {

    @Autowired
    private BillBookService billBookService;

    @GetMapping()
    public RespEntity getAllBook(){
        List<BillBook> list = billBookService.getAllBooks();
        return ResposeUtil.successWithData("",list);
    }

    @PostMapping
    public RespEntity addBook(@RequestBody BillBook book){
        BillBook billBook = billBookService.addAndUpdateBook(book);
        return ResposeUtil.successWithData("新增成功",billBook);
    }

    @PutMapping
    public RespEntity updateBook(@RequestBody BillBook book){
        BillBook billBook = billBookService.addAndUpdateBook(book);
        return ResposeUtil.successWithData("修改成功",billBook);
    }

    @DeleteMapping("/{id}")
    public RespEntity deleteBook(@PathVariable("id") int id){
        billBookService.deleteBook(id);
        return ResposeUtil.success("删除成功");
    }
}
