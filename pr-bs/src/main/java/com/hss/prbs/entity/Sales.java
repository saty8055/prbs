package com.hss.prbs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hss.prbs.config.constants.Library;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Sales {

    @Id
    @GeneratedValue(generator = Library.UUID)
    @GenericGenerator(name = Library.UUID, strategy = Library.UUID_2)
    private String saleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "medicineId")
    private Medicine medicine;

    private Integer units;

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }
}
