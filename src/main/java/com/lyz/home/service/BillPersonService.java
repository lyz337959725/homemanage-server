package com.lyz.home.service;

import com.lyz.home.entity.db.BillPerson;
import com.lyz.home.repository.BillPersonRepository;
import com.lyz.home.repository.BillPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillPersonService {

    @Autowired
    private BillPersonRepository billPersonRepository;

    public List<BillPerson> getAllPersons(){
        return (List<BillPerson>) billPersonRepository.findAll();
    }

    public BillPerson addAndUpdatePerson(BillPerson Person){
        return billPersonRepository.save(Person);
    }

    public void deletePerson(int id){
        billPersonRepository.deleteById(id);
    }
}
