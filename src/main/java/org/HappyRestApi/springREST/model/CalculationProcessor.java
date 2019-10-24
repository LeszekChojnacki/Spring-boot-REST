package org.HappyRestApi.springREST.model;

import org.HappyRestApi.springREST.domain.BankDeposit;
import org.HappyRestApi.springREST.domain.CalculationData;

public class CalculationProcessor {

    CalculationGateway calculationGateway = null;

    public void makeCalculation(CalculationData calculationData){
        CalculationGatewayFactory Factory = new CalculationGatewayFactory();
        this.calculationGateway = Factory.createCalculationGateway(calculationData.getAlgorithmType());
        this.calculationGateway.algorithm(calculationData);
    }
}
