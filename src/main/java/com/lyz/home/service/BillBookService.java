package com.lyz.home.service;

import com.lyz.home.entity.db.BillBook;
import com.lyz.home.repository.BillBookRepository;
import com.lyz.home.repository.BillTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillBookService {

    @Autowired
    private BillBookRepository billBookRepository;

    public List<BillBook> getAllBooks(){
        return (List<BillBook>) billBookRepository.findAll();
    }

    public BillBook addAndUpdateBook(BillBook book){
        return billBookRepository.save(book);
    }

    public void deleteBook(int id){
        billBookRepository.deleteById(id);
    }
}
