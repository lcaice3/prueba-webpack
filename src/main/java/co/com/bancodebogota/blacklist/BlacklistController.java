package co.com.bancodebogota.blacklist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

@CrossOrigin(origins = "*")
@RestController
public class BlacklistController {

    @Autowired
    private BlacklistService blacklistService;

    @GetMapping("/blacklist/check-costumer")
    public ResponseEntity<Boolean> checkCostumer(BlacklistRequestDTO blacklistRequest) {
        return new ResponseEntity<>(blacklistService.isInBlacklist(blacklistRequest), HttpStatus.OK);
    }

    @PostMapping("/blacklist/register-case")
    public JsonNode registerCase(@RequestBody BlacklistCaseRequestDTO blacklistCaseRequest)  {
        return blacklistService.registerCase(blacklistCaseRequest);
    }
}
