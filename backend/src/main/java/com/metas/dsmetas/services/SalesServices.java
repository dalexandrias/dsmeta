package com.metas.dsmetas.services;

import com.metas.dsmetas.entities.Sale;
import com.metas.dsmetas.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SalesServices {

    @Autowired
    private SalesRepository salesRepository;

    public List<Sale> findSales(){
        return salesRepository.findAll();
    }

    public Page<Sale> findPageSales(Pageable pageable) {
        return salesRepository.findAll(pageable);
    }

    public Page<Sale> findDateSales(LocalDate min, LocalDate max, Pageable pageable){
        return salesRepository.findPageSales(min, max, pageable);
    }
}
