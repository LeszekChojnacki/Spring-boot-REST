package org.HappyRestApi.springREST.domain;

import lombok.Data;
import org.HappyRestApi.springREST.domain.enums.Period;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Data
@Entity
public class BankDeposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double interest;

    @Enumerated(EnumType.ORDINAL)
    private Period capitalizationPeriod;
    private Date periodOfValidityStart;
    private Date periodOfValidityEnd;

    public BankDeposit(){}

    public BankDeposit(String name, double interest, Period capitalizationPeriod) {
        this.name = name;
        this.interest = interest;
        this.capitalizationPeriod = capitalizationPeriod;
        this.periodOfValidityStart = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(periodOfValidityStart);
        c.add(Calendar.DATE, capitalizationPeriod.getValue());
        this.periodOfValidityEnd = c.getTime();
    }

    public BankDeposit parce(){

        if(this.periodOfValidityStart == null){

            this.periodOfValidityStart = new Date();

            Calendar c = Calendar.getInstance();
            c.setTime(this.periodOfValidityStart);
            c.add(Calendar.DATE, capitalizationPeriod.getValue());
            this.periodOfValidityEnd = c.getTime();
        }
        return this;
    }
}
