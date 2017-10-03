package co.com.bancodebogota.simulator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import co.com.bancodebogota.simulator.dto.SimulatorParamsDTO;
import co.com.bancodebogota.simulator.dto.SimulatorRequestDTO;
import co.com.bancodebogota.simulator.dto.SimulatorResponseDTO;

@CrossOrigin(origins = "*")
@RestController
public class SimulatorController {

	@Autowired
	private SimulatorService simulatorService;
 
	@GetMapping("/simulator/simulate-loan")
	public ResponseEntity<SimulatorResponseDTO> getSimulationData(SimulatorRequestDTO request) {
		SimulatorResponseDTO response = simulatorService.getSimulatorData(request);
		return new ResponseEntity<SimulatorResponseDTO>(response, HttpStatus.OK);
	}
	
	@GetMapping("/simulator/simulation-params")
	public ResponseEntity<SimulatorParamsDTO> getSimulationParams() {
		SimulatorParamsDTO response = simulatorService.getSimulatorParams();
		return new ResponseEntity<SimulatorParamsDTO>(response, HttpStatus.OK);
	}
	
	@GetMapping("/simulator/rates-table")
	public ResponseEntity<double[][]> getRatesTable() {
		double [][] response = simulatorService.getRatesTable();
		return new ResponseEntity<double [][]>(response, HttpStatus.OK);
	}
}
