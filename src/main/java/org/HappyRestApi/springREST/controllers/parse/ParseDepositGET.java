package org.HappyRestApi.springREST.controllers.parse;

import lombok.Data;
import org.HappyRestApi.springREST.domain.BankDeposit;

@Data
public class ParseDepositGET {

    private Long id;
    private String name;

    public ParseDepositGET(BankDeposit bankDeposit) {
        this.id = bankDeposit.getId();
        this.name = bankDeposit.getName();
    }
}
