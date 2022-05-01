package com.hss.prbs.service.services;

import com.hss.prbs.config.exception.DataValidityException;
import com.hss.prbs.entity.Customer;
import com.hss.prbs.entity.Medicine;
import com.hss.prbs.entity.Sales;

import java.util.List;

public interface Service {

    Customer addCustomer(Customer customer);

    Medicine addMedicine(Medicine medicine);

    Sales sellMedicine(Sales sale) throws DataValidityException;

    List<Customer> customers();

    List<Sales> sales();

    List<Medicine> medicines();

}
