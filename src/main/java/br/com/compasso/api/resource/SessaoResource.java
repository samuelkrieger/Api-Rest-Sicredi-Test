package br.com.compasso.api.resource;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.api.model.SessaoResponse;
import br.com.compasso.api.model.request.PautaRequest;
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
	@ApiOperation(value = "Sessao Criada", nickname = "create", notes = "Criado Nova Sessao", response = ResponseEntity.class, tags = {
			"Creation" })
	@ApiResponses({ @ApiResponse(code = 201, message = "sessao-criada", response = ResponseEntity.class),
			@ApiResponse(code = 400, message = "sessao-error"), })

	public ResponseEntity<SessaoResponse> criarSessao(@PathParam("idPauta") PautaRequest request) {
	
		return ResponseEntity.ok(service.criarNovaSessao(request));
	}
	
	@GetMapping("/sessoes/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(
    		value = "Encontrar sessao pelo id", 
    		nickname = "find",
    		notes = "Encontrar uma sessao pelo id", 
    		response = ResponseEntity.class, 
    		tags = {"Find" })
    @ApiResponses({ 
    @ApiResponse(code = 200, message = "sessoes-encontradas", response = ResponseEntity.class),
	@ApiResponse(code = 404, message = "sessoes-nao-encontradas", response = ResponseEntity.class), })
    public ResponseEntity<Optional<SessaoResponse>> getSessao(@PathVariable("id") String id){
    	Long ids=Long.parseLong(id);
    	return ResponseEntity.ok(service.getSessaoId(ids));
    	
    }
}
