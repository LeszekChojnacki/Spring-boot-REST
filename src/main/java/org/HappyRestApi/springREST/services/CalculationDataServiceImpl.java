package org.HappyRestApi.springREST.services;

import org.HappyRestApi.springREST.domain.CalculationData;
import org.HappyRestApi.springREST.model.CalculationProcessor;
import org.HappyRestApi.springREST.repositories.BankDepositRepositorie;
import org.HappyRestApi.springREST.repositories.CalculationDataRepositorie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculationDataServiceImpl implements CalculationDataService {

    private final CalculationDataRepositorie calculationDataRepositorie;
    private final BankDepositRepositorie bankDepositRepositorie;

    public CalculationDataServiceImpl(CalculationDataRepositorie calculationDataRepositorie, BankDepositRepositorie bankDepositRepositorie) {
        this.calculationDataRepositorie = calculationDataRepositorie;
        this.bankDepositRepositorie = bankDepositRepositorie;
    }

    @Override
    public CalculationData findCalculationDataById(Long id) {
        return calculationDataRepositorie.findById(id).get();
    }

    @Override
    public List<CalculationData> findAllCalculationData() {
        return calculationDataRepositorie.findAll();
    }

    @Override
    public void addCalculationData(CalculationData calculationData) {
        CalculationProcessor processor = new CalculationProcessor();
        processor.makeCalculation(calculationData);
        this.bankDepositRepositorie.save(calculationData.getBankDeposit());
        this.calculationDataRepositorie.save(calculationData);
    }

    @Override
    public void deleteCalculationDataById (Long id){
        this.calculationDataRepositorie.deleteById(id);
    }
}
