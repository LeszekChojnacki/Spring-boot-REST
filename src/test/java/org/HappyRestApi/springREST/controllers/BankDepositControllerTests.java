package org.HappyRestApi.springREST.controllers;

import org.HappyRestApi.springREST.controllers.parse.ParseDepositGET;
import org.HappyRestApi.springREST.domain.BankDeposit;
import org.HappyRestApi.springREST.domain.enums.Period;
import org.HappyRestApi.springREST.services.BankDepositService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
public class BankDepositControllerTests {

	private BankDepositController bankDepositController;

	@Mock
	private BankDepositService bankDepositService;

	private List<BankDeposit> b1List;

	@Before
	public void init(){
		bankDepositController = new BankDepositController(bankDepositService);

		BankDeposit b1 = new BankDeposit("jakaslokata1", 0.1, Period.TWELVE_MONTHS);
		b1.setId(1L);

		b1List = new ArrayList<>();
		b1List.add(b1);

		List<ParseDepositGET> bankDeposits = new ArrayList<>();

		b1List.forEach((tmp) -> {
			bankDeposits.add(new ParseDepositGET(tmp));
		});

	}

	@Test
	public void getAllBankDepositTest_GetResult() throws Exception {
		when(bankDepositService.findAllBankDeposit()).thenReturn(b1List);
		ResponseEntity<List<ParseDepositGET>> result = bankDepositController.getAllBankDeposit();

		Assert.assertNotNull(result);
		Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
	}

	@Test
	public void getAllBankDepositTest_NotFound() throws Exception {
		when(bankDepositService.findAllBankDeposit()).thenReturn(null);
		ResponseEntity<List<ParseDepositGET>> result = bankDepositController.getAllBankDeposit();

		Assert.assertEquals(ResponseEntity.notFound().build(), result);
	}

}
