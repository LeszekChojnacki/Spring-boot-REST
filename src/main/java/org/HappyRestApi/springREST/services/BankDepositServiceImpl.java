package org.HappyRestApi.springREST.services;

import org.HappyRestApi.springREST.domain.BankDeposit;
import org.HappyRestApi.springREST.repositories.BankDepositRepositorie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankDepositServiceImpl implements BankDepositService {

    private final BankDepositRepositorie bankDepositRepositorie;

    public BankDepositServiceImpl(BankDepositRepositorie bankDepositRepositorie) {
        this.bankDepositRepositorie = bankDepositRepositorie;
    }

    @Override
    public BankDeposit findBankDepositById(Long id) {
        return bankDepositRepositorie.findById(id).get();
    }

    @Override
    public List<BankDeposit> findAllBankDeposit() {
        return bankDepositRepositorie.findAll();
    }

    @Override
    public void addBankDeposit(BankDeposit bankDeposit) {
        this.bankDepositRepositorie.save(bankDeposit);
    }

    @Override
    public void deleteBankDepositaById(Long id){
        this.bankDepositRepositorie.deleteById(id);
    }
}
