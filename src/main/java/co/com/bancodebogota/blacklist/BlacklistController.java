package co.com.bancodebogota.blacklist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import co.com.bancodebogota.blacklist.pojos.BlacklistParticipanteRqDto;
import co.com.bancodebogota.blacklist.pojos.BlacklistRegCasoRqDto;
import co.com.bancodebogota.services.BlacklistService;

@CrossOrigin(origins = "*")
@RestController
public class BlacklistController {

    @Autowired
    private BlacklistService blacklistService;

    @GetMapping("/blacklist/consultar-participante")
    public boolean consultarParticipante(BlacklistParticipanteRqDto blacklistParticipanteRqDto) {
        return blacklistService.participanteInBlacklist(blacklistParticipanteRqDto);
    }

    @PostMapping("/blacklist/registrar-caso")
    public JsonNode registrarCaso(@RequestBody BlacklistRegCasoRqDto blacklistRegCasoRqDto)  {
        return blacklistService.registrarCaso(blacklistRegCasoRqDto);
    }
}
