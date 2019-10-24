package org.HappyRestApi.springREST.repositories;

import org.HappyRestApi.springREST.domain.BankDeposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankDepositRepositorie extends JpaRepository<BankDeposit,Long> {
}
