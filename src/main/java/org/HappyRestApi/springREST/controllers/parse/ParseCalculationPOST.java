package org.HappyRestApi.springREST.controllers.parse;

import lombok.Data;
import org.HappyRestApi.springREST.domain.BankDeposit;
import org.HappyRestApi.springREST.domain.CalculationData;
import org.HappyRestApi.springREST.domain.enums.AlgorithmType;

import java.util.Date;

@Data
public class ParseCalculationPOST {

    private double amount;
    private Date calculationDate;
    private BankDeposit bankDeposit;
    private AlgorithmType algorithmType;
    private double profit;

    public ParseCalculationPOST(CalculationData calculationData) {
        this.amount = calculationData.getAmount();
        this.calculationDate = calculationData.getCalculationDate();
        this.bankDeposit = calculationData.getBankDeposit();
        this.algorithmType = calculationData.getAlgorithmType();
        this.profit = calculationData.getProfit();
    }
}
