package com.hss.prbs.repo;

import com.hss.prbs.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepo extends JpaRepository<Sales, String> {
}
