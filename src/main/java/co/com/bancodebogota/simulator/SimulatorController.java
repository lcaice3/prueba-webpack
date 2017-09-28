package co.com.bancodebogota.simulator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.bancodebogota.simulator.dto.SimulatorRequestDTO;
import co.com.bancodebogota.simulator.dto.SimulatorResponseDTO;

@CrossOrigin(origins = "*")
@RestController
public class SimulatorController {

	@Autowired
	private SimulatorService simulatorService;
 
	@GetMapping("/simulator/simulation-data")
	public ResponseEntity<SimulatorResponseDTO> getSimulationData(@RequestParam SimulatorRequestDTO request) {
		SimulatorResponseDTO response = simulatorService.getSimulatorData(request);
		return new ResponseEntity<SimulatorResponseDTO>(response, HttpStatus.OK);
	}
}
