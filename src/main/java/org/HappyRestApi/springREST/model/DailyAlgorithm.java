package org.HappyRestApi.springREST.model;

import org.HappyRestApi.springREST.domain.CalculationData;

public class DailyAlgorithm implements CalculationGateway {

    @Override
    public void algorithm(CalculationData calculationData) {

        double amount = calculationData.getAmount();
        double interest = calculationData.getBankDeposit().getInterest();
        int period = calculationData.getBankDeposit().getCapitalizationPeriod().getValue();
        double profit = Math.round(10.0*amount*interest*period*3/36)/10.0;

        calculationData.setProfit(profit);
    }
}
