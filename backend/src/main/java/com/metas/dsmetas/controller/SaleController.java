package com.metas.dsmetas.controller;

import com.metas.dsmetas.entities.Sale;
import com.metas.dsmetas.services.SalesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SalesServices salesServices;

    @GetMapping(value = "/search/all")
    public List<Sale> findSales(){
        return salesServices.findSales();
    }

    @GetMapping(value = "/search/page")
    public Page<Sale> findPageSales(Pageable pageable){
        return salesServices.findPageSales(pageable);
    }

    @GetMapping(value = "/search/date")
    public Page<Sale> findDateSales(
            @RequestParam(value = "dateMin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate min,
            @RequestParam(value = "dateMax") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate max,
            Pageable pageable
    ){
        return salesServices.findDateSales(min, max, pageable);
    }
}
