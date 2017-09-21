package co.com.bancodebogota.services.impl;

import java.util.LinkedHashMap;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.bancodebogota.digital.utilities.log.LoggerUtils;
import com.fasterxml.jackson.databind.JsonNode;

import co.com.bancodebogota.blacklist.pojos.BlacklistParticipanteRqDto;
import co.com.bancodebogota.blacklist.pojos.BlacklistRegCasoRqDto;
import co.com.bancodebogota.mappers.RequestMapper;
import co.com.bancodebogota.services.BlacklistService;

@Service("BlacklistServiceImpl")
public class BlacklistServiceImpl implements BlacklistService {

	@Value("${endpoint.blacklist.adapter}")
	private String endpointBlacklist;

	@Autowired
	private RequestMapper requestMapper;

	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public boolean participanteInBlacklist(BlacklistParticipanteRqDto blacklistParticipanteRqDto) {
		boolean clientInBlacklist = false;
		String resource = "blacklist/consultar-participante";
		LinkedHashMap<String, Object> params = new LinkedHashMap<>();
		String documentNumber = blacklistParticipanteRqDto.getDocumentNumber();
		params.put("documentNumber", documentNumber);
		params.put("firstName", blacklistParticipanteRqDto.getFirstName());
		params.put("secondSurname", blacklistParticipanteRqDto.getSecondSurname());
		params.put("surname", blacklistParticipanteRqDto.getSurname());
		params.put("activeLog", true);
		String requestParams = requestMapper.createRequestParamsUrl(params);
		String url = endpointBlacklist + resource + requestParams;

		try {
			restTemplate.getForObject(url, JsonNode.class);
			LoggerUtils.info("Client: " + documentNumber + " not in black list");
		} catch (HttpStatusCodeException ex) {
			if (ex.getRawStatusCode() == HttpStatus.SC_UNAUTHORIZED) {
				clientInBlacklist = true;
				LoggerUtils.info("Participante en blacklist, request: " + blacklistParticipanteRqDto);
			} else {
				LoggerUtils.info("Error general blacklist, document: " + documentNumber);
				throw ex;
			}
		}

		return clientInBlacklist;
	}

	@Override
	public JsonNode registrarCaso(BlacklistRegCasoRqDto blacklistRegCasoRqDto) {
		String resource = "blacklist/registrar-caso";
		String url = endpointBlacklist + resource;
		return restTemplate.postForObject(url, blacklistRegCasoRqDto, JsonNode.class);
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
}
