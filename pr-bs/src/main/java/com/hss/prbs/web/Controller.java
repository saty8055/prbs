package com.hss.prbs.web;

import com.hss.prbs.config.constants.Url;
import com.hss.prbs.config.exception.DataValidityException;
import com.hss.prbs.entity.Customer;
import com.hss.prbs.entity.Medicine;
import com.hss.prbs.entity.Sales;
import com.hss.prbs.service.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

/**
 * @description controller service for App
 */
@CrossOrigin
@RestController
@RequestMapping(Url.SECURE_URL)
public class Controller {

    @Autowired
    Service service;

    @PostMapping("/customer")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(service.addCustomer(customer));
    }

    @PostMapping("/medicine")
    public ResponseEntity<?> addMedicine(@RequestBody Medicine medicine){
        return ResponseEntity.ok(service.addMedicine(medicine));
    }

    @PostMapping("/sales")
    public ResponseEntity<?> addSales(@RequestBody Sales sales) throws DataValidityException {
        return ResponseEntity.ok(service.sellMedicine(sales));
    }

    @GetMapping("/medicine")
    public ResponseEntity<?> medicines(){
        return ResponseEntity.ok(service.medicines());
    }

    @GetMapping("/customer")
    public ResponseEntity<?> customers(){
        return ResponseEntity.ok(service.customers());
    }

    @GetMapping("/sales")
    public ResponseEntity<?> sales(){
        return ResponseEntity.ok(service.sales());
    }

}
