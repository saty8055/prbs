package com.hss.prbs.repo;

import com.hss.prbs.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepo extends JpaRepository<Medicine, String> {
}
