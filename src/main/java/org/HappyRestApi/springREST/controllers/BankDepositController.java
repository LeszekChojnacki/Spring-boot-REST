package org.HappyRestApi.springREST.controllers;

import lombok.Data;
import org.HappyRestApi.springREST.controllers.parse.ParseDepositGET;
import org.HappyRestApi.springREST.controllers.parse.ParseDepositPOST;
import org.HappyRestApi.springREST.domain.BankDeposit;
import org.HappyRestApi.springREST.services.BankDepositService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Data
@RestController
public class BankDepositController {

    private BankDepositService bankDepositService;

    public BankDepositController(BankDepositService bankDepositService) {
        this.bankDepositService = bankDepositService;
    }

    @GetMapping("api/investments")
    public ResponseEntity<List<ParseDepositGET>> getAllBankDeposit() {

        List<BankDeposit> bankDeposits = bankDepositService.findAllBankDeposit();

        if(bankDeposits == null)
            return ResponseEntity.notFound().build();

        List<ParseDepositGET> parseDeposits = new ArrayList<>();

        bankDepositService.findAllBankDeposit()
                .forEach((tmp) -> {
                    parseDeposits.add(new ParseDepositGET(tmp));
                });

        return new ResponseEntity<List<ParseDepositGET>> (
                parseDeposits,
                HttpStatus.OK
        );
    }

    @RequestMapping(method = RequestMethod.POST, value="api/investments")
    public ResponseEntity<ParseDepositPOST> addCalculationData(@RequestBody BankDeposit bankDeposit){

        this.bankDepositService.addBankDeposit(bankDeposit.parce());

        return new ResponseEntity<ParseDepositPOST>(
                new ParseDepositPOST(bankDeposit),
                HttpStatus.OK
        );
    }
}
