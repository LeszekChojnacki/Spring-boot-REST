package org.HappyRestApi.springREST.controllers.parse;

import lombok.Data;
import org.HappyRestApi.springREST.domain.BankDeposit;

@Data
public class ParseDepositPOST {

    private Long id;
    private String name;
    private double interest;
    private int capitalizationPeriod;

    public ParseDepositPOST(BankDeposit bankDeposit) {
        this.id = bankDeposit.getId();
        this.name = bankDeposit.getName();
        this.interest = bankDeposit.getInterest();
        this.capitalizationPeriod = bankDeposit.getCapitalizationPeriod().getValue()*30;
    }
}
