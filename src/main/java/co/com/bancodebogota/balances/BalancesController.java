package co.com.bancodebogota.balances;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.bancodebogota.balances.pojos.IsUpdatableRs;
import co.com.bancodebogota.balances.services.BalanceFacade;

@CrossOrigin(origins = "*")
@RestController
public class BalancesController {

	@Autowired
	private BalanceFacade balanceFacade;

	@GetMapping("/client/is-updatable")
	public IsUpdatableRs isUpdatable(@RequestParam String documentNumber) {
		return balanceFacade.checkUser(documentNumber);
	}

}
