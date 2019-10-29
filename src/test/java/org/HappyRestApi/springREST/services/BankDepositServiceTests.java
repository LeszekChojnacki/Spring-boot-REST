package org.HappyRestApi.springREST.services;

import org.HappyRestApi.springREST.domain.BankDeposit;
import org.HappyRestApi.springREST.domain.enums.Period;
import org.HappyRestApi.springREST.repositories.BankDepositRepositorie;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
public class BankDepositServiceTests {

	private BankDepositServiceImpl bankDepositService;
	private BankDeposit b1;
	private List<BankDeposit> b1List;

	@Mock
	BankDepositRepositorie bankDepositRepositorie;

	@Before
	public void init() throws Exception{
		bankDepositService = new BankDepositServiceImpl(bankDepositRepositorie);

		b1 = new BankDeposit("jakaslokata1", 0.1, Period.TWELVE_MONTHS);
		b1.setId(1L);

		b1List = new ArrayList<>();
		b1List.add(b1);
	}

	@Test
	public void findBankDepositByIdTest() throws Exception {

		when(bankDepositRepositorie.findById(anyLong())).thenReturn(Optional.of(b1));
		BankDeposit result = bankDepositService.findBankDepositById(1L);

		Assert.assertNotNull(result);
		Assert.assertEquals("jakaslokata1", result.getName());
	}

	@Test
	public void findAllBankDepositTest() throws Exception {

		when(bankDepositRepositorie.findAll()).thenReturn(b1List);
		List<BankDeposit> result = bankDepositService.findAllBankDeposit();

		Assert.assertNotNull(result);
		Assert.assertEquals("jakaslokata1", result.get(0).getName());
	}


}
