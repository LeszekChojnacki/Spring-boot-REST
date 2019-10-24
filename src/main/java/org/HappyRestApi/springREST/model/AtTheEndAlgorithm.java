package org.HappyRestApi.springREST.model;

import org.HappyRestApi.springREST.domain.BankDeposit;
import org.HappyRestApi.springREST.domain.CalculationData;

public class AtTheEndAlgorithm implements CalculationGateway{

    @Override
    public void algorithm(CalculationData calculationData) {

        double amount = calculationData.getAmount();
        double interest = calculationData.getBankDeposit().getInterest();
        int period = calculationData.getBankDeposit().getCapitalizationPeriod().getValue();
        double profit = amount*interest*period*3/36;

        calculationData.setProfit(profit);
    }
}
