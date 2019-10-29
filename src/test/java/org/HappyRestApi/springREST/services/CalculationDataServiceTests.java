package org.HappyRestApi.springREST.services;

import org.HappyRestApi.springREST.domain.BankDeposit;
import org.HappyRestApi.springREST.domain.CalculationData;
import org.HappyRestApi.springREST.domain.enums.AlgorithmType;
import org.HappyRestApi.springREST.domain.enums.Period;
import org.HappyRestApi.springREST.repositories.BankDepositRepositorie;
import org.HappyRestApi.springREST.repositories.CalculationDataRepositorie;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
public class CalculationDataServiceTests {

	private CalculationDataServiceImpl calculationDataService ;
	private CalculationData c1;
	private List<CalculationData> c1List;

	@Mock
	CalculationDataRepositorie calculationDataRepositorie;
	@Mock
	BankDepositRepositorie bankDepositRepositorie;

	@Before
	public void init() throws Exception{
		calculationDataService = new CalculationDataServiceImpl(calculationDataRepositorie, bankDepositRepositorie);

		BankDeposit b1 = new BankDeposit("jakaslokata1", -0.1, Period.TWELVE_MONTHS);
		b1.setId(1L);

		c1 = new CalculationData();
		c1.setId(1L);
		c1.setAmount(1000.0);
		c1.setCalculationDate(new Date());
		c1.setBankDeposit(b1);
		c1.setAlgorithmType(AlgorithmType.DAILY);
		c1.setProfit(1.11);

		c1List = new ArrayList<>();
		c1List.add(c1);
	}

	@Test
	public void findCalculationDataByIdTest() throws Exception {

		when(calculationDataRepositorie.findById(anyLong())).thenReturn(Optional.of(c1));
		CalculationData result = calculationDataService.findCalculationDataById(1L);

		Assert.assertNotNull(result);
		Assert.assertEquals(AlgorithmType.DAILY, result.getAlgorithmType());
	}

	@Test
		public void findAllCalculationDataTest() throws Exception {

		when(calculationDataRepositorie.findAll()).thenReturn(c1List);
		List<CalculationData> result = calculationDataService.findAllCalculationData();

		Assert.assertNotNull(result);
		Assert.assertEquals(AlgorithmType.DAILY, result.get(0).getAlgorithmType());
	}

}
