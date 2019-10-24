package org.HappyRestApi.springREST.model;

import org.HappyRestApi.springREST.domain.BankDeposit;
import org.HappyRestApi.springREST.domain.CalculationData;

public interface CalculationGateway {

    public void algorithm(CalculationData calculationData);
}
