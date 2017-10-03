package co.com.bancodebogota.simulator;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import co.com.bancodebogota.simulator.dto.SimulatorParamsDTO;
import co.com.bancodebogota.simulator.dto.SimulatorRequestDTO;
import co.com.bancodebogota.simulator.dto.SimulatorResponseDTO;

@RunWith(SpringRunner.class)
@WebMvcTest(SimulatorController.class)
public class SimulatorControllerTests {

	@Autowired
	public MockMvc mockMvc;

	@MockBean
	public SimulatorService simulatorService;

	@Test
	public void testSimulateLoan() throws Exception {

		SimulatorResponseDTO response = new SimulatorResponseDTO();
		
		response.setLifeInsurance(0.005);
		response.setMaxLoanAmount(10000000);
		response.setPayment(400000);
		response.setRateEA(0.16);
		response.setRateNMV(0.15);
		response.setRateVTUA(0.17);

		String expected = "{'lifeInsurance': 0.005, 'maxLoanAmount': 10000000," + 
						  "'payment': 400000, 'rateEA': 0.16, 'rateNMV': 0.15," + 
						  "'rateVTUA': 0.17}";

		when(simulatorService.getSimulatorData(any(SimulatorRequestDTO.class))).thenReturn(response);

		this.mockMvc.perform(get("/simulator/simulate-loan")
						.param("amount", "10000000")
						.param("discount", "500000")
						.param("numPeriods", "12")
						.param("salary", "2000000"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(expected));
	}
	
	@Test
	public void testSimulationParams() throws Exception {

		SimulatorParamsDTO response = new SimulatorParamsDTO();
		
		response.setAmountStep(1000000);
		response.setMaxAmount(1000000000);
		response.setMaxPeriods(72);
		response.setMinAmount(500000);
		response.setMinPeriods(6);
		response.setPeriodStep(12);
		response.setPerLifeInsurance(0.05);
		

		String expected = "{'amountStep': 1000000, 'maxAmount': 1000000000," + 
						  "'maxPeriods': 72, 'minAmount': 500000, 'minPeriods': 6," + 
						  "'periodStep': 12, 'perLifeInsurance': 0.05 }";

		when(simulatorService.getSimulatorParams()).thenReturn(response);

		this.mockMvc.perform(get("/simulator/simulation-params"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(expected));
	}
	
	@Test
	public void testgetRatesTable() throws Exception {

		double [][] response = {{0.25, 0.25},
							    {0.25, 0.25}};
		
		when(simulatorService.getRatesTable()).thenReturn(response);

		this.mockMvc.perform(get("/simulator/rates-table"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("[[0.25,0.25],[0.25,0.25]]"));
	}
}
