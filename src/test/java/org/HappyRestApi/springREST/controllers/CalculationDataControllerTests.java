package org.HappyRestApi.springREST.controllers;

import org.HappyRestApi.springREST.domain.BankDeposit;
import org.HappyRestApi.springREST.domain.CalculationData;
import org.HappyRestApi.springREST.domain.enums.AlgorithmType;
import org.HappyRestApi.springREST.domain.enums.Period;
import org.HappyRestApi.springREST.services.CalculationDataService;
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

import java.util.Date;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
public class CalculationDataControllerTests {

	private CalculationDataController calculationDataController;

	@Mock
	private CalculationDataService calculationDataService;

	private CalculationData c1;

	@Before
	public void init(){
		calculationDataController = new CalculationDataController(calculationDataService);

		BankDeposit b1 = new BankDeposit("jakaslokata1", 0.1, Period.TWELVE_MONTHS);
		b1.setId(1L);

		c1 = new CalculationData();
		c1.setId(1L);
		c1.setAmount(1000.0);
		c1.setCalculationDate(new Date());
		c1.setBankDeposit(b1);
		c1.setAlgorithmType(AlgorithmType.DAILY);
		c1.setProfit(1.11);
	}

	@Test
	public void getCalculationDtaByIdTests_GetResult() throws Exception {
		when(calculationDataService.findCalculationDataById(anyLong())).thenReturn(c1);
		ResponseEntity<CalculationData> result = calculationDataController.getCalculationDtaById(1L);

		Assert.assertNotNull(result);
		Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
	}

	@Test
	public void getCalculationDtaByIdTests_NotFound() throws Exception {
		when(calculationDataService.findCalculationDataById(anyLong())).thenReturn(null);
		ResponseEntity<CalculationData> result = calculationDataController.getCalculationDtaById(null);

		Assert.assertNotNull(result);
		Assert.assertEquals(ResponseEntity.notFound().build(), result);
	}


}
