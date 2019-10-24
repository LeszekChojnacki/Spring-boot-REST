package org.HappyRestApi.springREST.domain;

import lombok.Data;
import org.HappyRestApi.springREST.domain.enums.Period;

import javax.persistence.*;
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
}
