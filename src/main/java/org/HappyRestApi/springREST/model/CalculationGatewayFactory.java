package org.HappyRestApi.springREST.model;

import org.HappyRestApi.springREST.domain.enums.AlgorithmType;

public class CalculationGatewayFactory {

    public CalculationGateway createCalculationGateway (AlgorithmType algorithmType) {

        CalculationGateway calculationGateway = null;

        switch(algorithmType){
            case DAILY:
                calculationGateway = new DailyAlgorithm();
                break;
            case ATTHEEND:
                calculationGateway = new AtTheEndAlgorithm();
                break;
            default:
                break;
        }
        return calculationGateway;
    }
}
