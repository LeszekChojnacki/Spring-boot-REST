//package org.HappyRestApi.springREST.bootstrap;
//
//import org.HappyRestApi.springREST.domain.BankDeposit;
//import org.HappyRestApi.springREST.domain.CalculationData;
//import org.HappyRestApi.springREST.domain.enums.AlgorithmType;
//import org.HappyRestApi.springREST.domain.enums.Period;
//import org.HappyRestApi.springREST.repositories.BankDepositRepositorie;
//import org.HappyRestApi.springREST.repositories.CalculationDataRepositorie;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import java.util.Date;
//
//@Component
//public class BootStrapData implements CommandLineRunner {
//
//    private final CalculationDataRepositorie calculationDataRepositorie;
//    private final BankDepositRepositorie bankDepositRepositorie;
//
//    public BootStrapData(CalculationDataRepositorie calculationDataRepositorie, BankDepositRepositorie bankDepositRepositorie) {
//        this.calculationDataRepositorie = calculationDataRepositorie;
//        this.bankDepositRepositorie = bankDepositRepositorie;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        System.out.println("Loading Calculation and Bank deposit data...");
//
//        BankDeposit b1 = new BankDeposit();
//        b1.setName("jakaslokata1");
//        b1.setInterest(111.11);
//        b1.setCapitalizationPeriod(Period.TWELVE_MONTHS);
//        b1.setPeriodOfValidityStart(new Date());
//        b1.setPeriodOfValidityEnd(new Date());
//        bankDepositRepositorie.save(b1);
//
//        CalculationData c1 = new CalculationData();
//        c1.setAmount(1.11);
//        c1.setCalculationDate(new Date());
//        c1.setBankDeposit(b1);
//        c1.setAlgorithmType(AlgorithmType.DAILY);
//        c1.setProfit(1.11);
//        calculationDataRepositorie.save(c1);
//
//        BankDeposit b2 = new BankDeposit();
//        b2.setName("jakaslokata1");
//        b2.setInterest(222.11);
//        b2.setCapitalizationPeriod(Period.SIX_MONTHS);
//        b2.setPeriodOfValidityStart(new Date());
//        b2.setPeriodOfValidityEnd(new Date());
//        bankDepositRepositorie.save(b2);
//
//        CalculationData c2 = new CalculationData();
//        c2.setAmount(2.22);
//        c2.setCalculationDate(new Date());
//        c2.setBankDeposit(b2);
//        c2.setAlgorithmType(AlgorithmType.DAILY);
//        c2.setProfit(2.22);
//        calculationDataRepositorie.save(c2);
//
//        BankDeposit b3 = new BankDeposit();
//        b3.setName("jakaslokata1");
//        b3.setInterest(333.11);
//        b3.setCapitalizationPeriod(Period.ONE_MONTH);
//        b3.setPeriodOfValidityStart(new Date());
//        b3.setPeriodOfValidityEnd(new Date());
//        bankDepositRepositorie.save(b3);
//
//        CalculationData c3 = new CalculationData();
//        c3.setAmount(3.33);
//        c3.setCalculationDate(new Date());
//        c3.setBankDeposit(b3);
//        c3.setAlgorithmType(AlgorithmType.ATTHEEND);
//        c3.setProfit(3.33);
//        calculationDataRepositorie.save(c3);
//
//        System.out.println("Calculaions data saved: "+calculationDataRepositorie.count());
//        System.out.println("Bank deposit data saved: "+bankDepositRepositorie.count());
//    }
//}
