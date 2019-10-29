package org.HappyRestApi.springREST.integration;

import org.HappyRestApi.springREST.domain.BankDeposit;
import org.HappyRestApi.springREST.domain.CalculationData;
import org.HappyRestApi.springREST.domain.enums.AlgorithmType;
import org.HappyRestApi.springREST.domain.enums.Period;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
public class IntegrationTestsIT {

	@Autowired
	private TestRestTemplate restTemplate;

	private BankDeposit b1;
	private CalculationData c1;

	@Before
	public void init(){

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
	public void getAllBankDepositTest_GetResult(){
		ResponseEntity<Object[]> response = restTemplate.getForEntity("http://localhost:8080/api/investments", Object[].class);

		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void addCalculationDataTest_PostResult(){
		ResponseEntity<Object> response = restTemplate.postForEntity("http://localhost:8080/api/investments", b1, Object.class);

		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
	}

	@Test
	public void getCalculationDtaById_GetResult(){
		ResponseEntity<Object> response = restTemplate.getForEntity("http://localhost:8080/api/investments/1/calculations", Object.class);

		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void addCalculationData_PostResult(){
		ResponseEntity<Object> response = restTemplate.postForEntity("http://localhost:8080/api/investments/calculations",c1, Object.class);

		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
	}

}
