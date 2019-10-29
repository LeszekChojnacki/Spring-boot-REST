package org.HappyRestApi.springREST.model;

import org.HappyRestApi.springREST.domain.BankDeposit;
import org.HappyRestApi.springREST.domain.CalculationData;
import org.HappyRestApi.springREST.domain.enums.AlgorithmType;
import org.HappyRestApi.springREST.domain.enums.Period;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
public class CalculationProcessorTest {

    private CalculationProcessor processor;
    private CalculationData c1;
    private CalculationData c2;
    private CalculationData c3;
    private CalculationData c4;

    @Before
    public void init(){

        processor= new CalculationProcessor();

        BankDeposit b1 = new BankDeposit("jakaslokata1",0.1, Period.TWELVE_MONTHS);

        c1 = new CalculationData();
        c1.setAmount(1000.0);
        c1.setCalculationDate(new Date());
        c1.setBankDeposit(b1);
        c1.setAlgorithmType(AlgorithmType.DAILY);
        c1.setProfit(1.11);

        c2 = new CalculationData();
        c2.setAmount(0.0);
        c2.setCalculationDate(new Date());
        c2.setBankDeposit(b1);
        c2.setAlgorithmType(AlgorithmType.DAILY);
        c2.setProfit(1.11);

        c3 = new CalculationData();
        c3.setAmount(-1000.0);
        c3.setCalculationDate(new Date());
        c3.setBankDeposit(b1);
        c3.setAlgorithmType(AlgorithmType.DAILY);
        c3.setProfit(1.11);

        BankDeposit b2 = new BankDeposit("jakaslokata1", -0.1, Period.TWELVE_MONTHS);

        c4 = new CalculationData();
        c4.setAmount(1000.0);
        c4.setCalculationDate(new Date());
        c4.setBankDeposit(b2);
        c4.setAlgorithmType(AlgorithmType.DAILY);
        c4.setProfit(1.11);
    }


    @Test
    public void makeCalculationTest(){
        processor.makeCalculation(c1);
        Assertions.assertThat(c1.getProfit()).isEqualTo(100.0);
    }

    @Test
    public void makeCalculationTest_ZeroAmount(){
        processor.makeCalculation(c2);
        Assertions.assertThat(c2.getProfit()).isEqualTo(0.0);
    }

    @Test
    public void makeCalculationTest_NegativeValuesAmount(){
        processor.makeCalculation(c3);
        Assertions.assertThat(c3.getProfit()).isEqualTo(-100.0);
    }

    @Test
    public void makeCalculationTest_NegativeValuesInterest(){
        processor.makeCalculation(c4);
        Assertions.assertThat(c4.getProfit()).isEqualTo(-100.0);
    }
}
