package org.HappyRestApi.springREST.services;

import org.HappyRestApi.springREST.domain.CalculationData;

import java.util.List;

public interface CalculationDataService {

    CalculationData findCalculationDataById (Long id);

    List<CalculationData> findAllCalculationData();

    void addCalculationData(CalculationData calculationData);

    void deleteCalculationDataById(Long id);
}
