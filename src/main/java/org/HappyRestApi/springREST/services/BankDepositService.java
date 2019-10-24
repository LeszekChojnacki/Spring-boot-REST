package org.HappyRestApi.springREST.services;

import org.HappyRestApi.springREST.domain.BankDeposit;

import java.util.List;

public interface BankDepositService {

    BankDeposit findBankDepositById (Long id);

    List<BankDeposit> findAllBankDeposit();

    void addBankDeposit(BankDeposit bankDeposit);

    void deleteBankDepositaById(Long id);
}
