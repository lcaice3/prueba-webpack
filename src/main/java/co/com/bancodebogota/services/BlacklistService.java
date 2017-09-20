package co.com.bancodebogota.services;

import com.fasterxml.jackson.databind.JsonNode;

import co.com.bancodebogota.blacklist.pojos.BlacklistParticipanteRqDto;
import co.com.bancodebogota.blacklist.pojos.BlacklistRegCasoRqDto;

public interface BlacklistService {

	boolean participanteInBlacklist(BlacklistParticipanteRqDto blacklistParticipanteRqDto);

	JsonNode registrarCaso(BlacklistRegCasoRqDto blacklistRegCasoRqDto);

}
