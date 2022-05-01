package com.hss.prbs.service.services;

import com.hss.prbs.config.exception.DataValidityException;
import com.hss.prbs.entity.Customer;
import com.hss.prbs.entity.Medicine;
import com.hss.prbs.entity.Sales;
import com.hss.prbs.repo.CustomerRepo;
import com.hss.prbs.repo.MedicineRepo;
import com.hss.prbs.repo.SalesRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    SalesRepo salesRepo;

    @Autowired
    MedicineRepo medicineRepo;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Medicine addMedicine(Medicine medicine) {
        return medicineRepo.save(medicine);
    }

    @Override
    @Transactional
    public Sales sellMedicine(Sales sale) throws DataValidityException {
        if(sale.getMedicine() == null || sale.getMedicine().getMedicineId() == null || sale.getMedicine().getMedicineId().isEmpty())
            throw new DataValidityException("Invalid Medicine !");

        Optional<Medicine> library = medicineRepo.findById(sale.getMedicine().getMedicineId());

        if(!library.isPresent())
            throw new DataValidityException("Invalid Medicine !");

        Medicine medicine = library.get();

        if(sale.getUnits() > medicine.getStock())
            throw new DataValidityException("Insufficient Stock !");

        medicine.setStock(medicine.getStock()-sale.getUnits());
        medicine = medicineRepo.save(medicine);

        return salesRepo.save(sale);
    }

    @Override
    public List<Customer> customers() {
        return customerRepo.findAll();
    }

    @Override
    public List<Sales> sales() {
        return salesRepo.findAll();
    }

    @Override
    public List<Medicine> medicines() {
        return medicineRepo.findAll();
    }
}
