package br.com.compasso.api.resource;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.api.persistence.domain.PautaEntity;
import br.com.compasso.api.response.SessaoCreatedResponse;
import br.com.compasso.api.response.SessaoFoundResponse;
import br.com.compasso.api.service.SessaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "sessao")
@RequestMapping("/sessao")
public class SessaoResource {

	@Autowired
	private SessaoService service;

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Sessao Criada", nickname = "create", notes = "Criado Nova Sessao", response = SessaoCreatedResponse.class, tags = {
			"Creation" })
	@ApiResponses({ @ApiResponse(code = 201, message = "sessao-criada", response = SessaoCreatedResponse.class),
			@ApiResponse(code = 400, message = "sessao-error"), })

	public SessaoCreatedResponse criarSessao(@PathParam("idPauta") PautaEntity entity) {
		service.criarNovaSessao(entity);
		return new SessaoCreatedResponse("pauta", entity);
	}

	@GetMapping("/sessoes/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Encontrar sessao pelo id", nickname = "find", notes = "Encontrar uma sessao pelo id", response =  SessaoFoundResponse.class, tags = {
			"Find" })
	@ApiResponses({ @ApiResponse(code = 200, message = "sessoes-encontradas", response = SessaoFoundResponse.class),
			@ApiResponse(code = 404, message = "sessoes-nao-encontradas", response = SessaoFoundResponse.class), })
	public SessaoFoundResponse getSessao(@PathVariable("id") String id) {
		Long ids = Long.parseLong(id);
		service.getSessaoId(ids);

		return new SessaoFoundResponse();

	}
}
