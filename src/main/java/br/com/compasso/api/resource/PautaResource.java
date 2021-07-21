package br.com.compasso.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.api.persistence.domain.PautaEntity;
import br.com.compasso.api.response.PautaCreatedResponse;
import br.com.compasso.api.response.PautaFoundAllResponse;
import br.com.compasso.api.response.PautaFoundResponse;
import br.com.compasso.api.service.PautaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "pauta")
@RequestMapping("/pauta")
public class PautaResource {

	@Autowired
	private PautaService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Pauta Criada", nickname = "create", notes = "Criado Nova Pauta", response = PautaCreatedResponse.class, tags = {
			"Creation" })
	@ApiResponses({ @ApiResponse(code = 201, message = "pauta-criada", response = PautaCreatedResponse.class),
			@ApiResponse(code = 400, message = "pauta-error"), })
	public PautaCreatedResponse criarPauta(@RequestBody PautaEntity entity) {
		service.criarNovaPauta(entity);
		return new PautaCreatedResponse(entity);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Encontrar Pauta pelo ID", nickname = "find", notes = "Encontrar Pauta existente pelo ID", response = PautaFoundResponse.class, tags = {
			"Find" })
	@ApiResponses({ @ApiResponse(code = 200, message = "pauta-encontrada", response = PautaFoundResponse.class),
			@ApiResponse(code = 404, message = "pauta-nao-encontrada", response = PautaFoundResponse.class), })
	public PautaFoundResponse getPauta(@PathVariable("id") Long id) {
		PautaEntity response = service.get(id);
		response.map(ResponseEntity::ok);
		return new PautaFoundResponse(response);
	}

	@GetMapping("/")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Encontrar todas as Pautas", nickname = "findAll", notes = "Encontrar todas as Pautas existentes", response = PautaFoundAllResponse.class, tags = {
			"FindAll" })
	@ApiResponses({ @ApiResponse(code = 200, message = "pautas-encontradas", response = PautaFoundAllResponse.class),
			@ApiResponse(code = 404, message = "pautas-nao-encontradas", response = PautaFoundAllResponse.class), })
	public PautaFoundAllResponse getPautas() {
		List<PautaEntity> responses = service.getAll();
		return new PautaFoundAllResponse((PautaEntity) responses);

	}

}
