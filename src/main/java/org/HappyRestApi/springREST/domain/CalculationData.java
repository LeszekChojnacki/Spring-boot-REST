package org.HappyRestApi.springREST.domain;

import lombok.Data;
import org.HappyRestApi.springREST.domain.enums.AlgorithmType;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class CalculationData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    private Date calculationDate;
    private double profit;

    @Enumerated(EnumType.ORDINAL)
    private AlgorithmType algorithmType;

    @OneToOne(cascade = {CascadeType.MERGE})
    private BankDeposit bankDeposit;

}
