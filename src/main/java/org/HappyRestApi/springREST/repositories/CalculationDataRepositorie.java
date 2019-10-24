package org.HappyRestApi.springREST.repositories;

import org.HappyRestApi.springREST.domain.CalculationData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculationDataRepositorie extends JpaRepository<CalculationData, Long> {
}
