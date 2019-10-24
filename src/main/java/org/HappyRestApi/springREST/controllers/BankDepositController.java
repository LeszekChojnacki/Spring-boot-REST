package org.HappyRestApi.springREST.controllers;

import org.HappyRestApi.springREST.controllers.parse.ParseDepositGET;
import org.HappyRestApi.springREST.controllers.parse.ParseDepositPOST;
import org.HappyRestApi.springREST.domain.BankDeposit;
import org.HappyRestApi.springREST.services.BankDepositService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BankDepositController {

    private BankDepositService bankDepositService;

    public BankDepositController(BankDepositService bankDepositService) {
        this.bankDepositService = bankDepositService;
    }

    @GetMapping("api/investments")
    List<ParseDepositGET> getAllBankDeposit(){
        List<ParseDepositGET> BankDeposits = new ArrayList<>();

        bankDepositService.findAllBankDeposit()
                .forEach((tmp)->{
                    BankDeposits.add(new ParseDepositGET(tmp));
                });

        return BankDeposits;
    }

    @RequestMapping(method = RequestMethod.POST, value="api/investments")
    public ParseDepositPOST addCalculationData(@RequestBody BankDeposit bankDeposit){
        this.bankDepositService.addBankDeposit(bankDeposit);
        return new ParseDepositPOST(bankDeposit);
    }
}
