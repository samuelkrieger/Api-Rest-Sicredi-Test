package br.com.compasso.api.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.api.model.request.PautaRequest;
import br.com.compasso.api.model.response.PautaResponse;
import br.com.compasso.api.model.response.SessaoResponse;
import br.com.compasso.api.persistence.domain.OpcaoVoto;
import br.com.compasso.api.persistence.domain.Pauta;
import br.com.compasso.api.persistence.domain.Sessao;
import br.com.compasso.api.persistence.domain.Voto;
import br.com.compasso.api.service.PautaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "api")
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private  PautaService service;
	

    @SuppressWarnings("static-access")
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Pauta Criada", 
    			  nickname = "create", 
    			  notes = "Criado Nova Pauta", 
    			  response = ResponseEntity.class, 
    			  tags = {
				 "Creation" })
    @ApiResponses({ 
    	@ApiResponse(code = 201, 
    			message = "pauta-criada", 
    			response = ResponseEntity.class),
	@ApiResponse(code = 400, 
				message = "pauta-error"), })
    public ResponseEntity<PautaResponse> criarPauta(@RequestBody PautaRequest request){

    	return ResponseEntity.status(HttpStatus.CREATED).build().ok(service.criarNovaPauta(request));
    }
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(
    		value = "Encontrar Pauta pelo ID", 
    		nickname = "find",
    		notes = "Encontrar Pauta existente pelo ID", 
    		response = ResponseEntity.class, 
    		tags = {"Find" })
    @ApiResponses({ 
    	@ApiResponse(code = 200, message = "pauta-encontrada", response = ResponseEntity.class),
	@ApiResponse(code = 404, message = "pauta-nao-encontrada", response = ResponseEntity.class), })
    public ResponseEntity<Pauta> getPauta(@PathVariable("id") Long id){
    	Optional<Pauta> response = service.get(id);
    	return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }
    @SuppressWarnings("static-access")
	@GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(
    		value = "Encontrar todas as Pautas", 
    		nickname = "findAll",
    		notes = "Encontrar todas as Pautas existentes", 
    		response = ResponseEntity.class, 
    		tags = {"FindAll" })
    @ApiResponses({ 
    	@ApiResponse(code = 200, message = "pautas-encontradas", response = ResponseEntity.class),
	@ApiResponse(code = 404, message = "pautas-nao-encontradas", response = ResponseEntity.class), })
    public ResponseEntity<Page<PautaResponse>> getPautas(Pageable pageable){
    	Page<PautaResponse> responses = service.getAll(pageable);
    	
    	return ResponseEntity.status(HttpStatus.CREATED).build().ok(responses);
    	
    }
    @SuppressWarnings("static-access")
	@PostMapping("/sessao")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Sessao Criada", 
    			  nickname = "create", 
    			  notes = "Criado Nova Sessao", 
    			  response = ResponseEntity.class, 
    			  tags = {
				 "Creation" })
    @ApiResponses({ 
    	@ApiResponse(code = 201, 
    			message = "sessao-criada", 
    			response = ResponseEntity.class),
	@ApiResponse(code = 400, 
				message = "sessao-error"), })
    
    public ResponseEntity<SessaoResponse> criarSessao(@PathParam("idPauta")
           PautaRequest request) {
    	  LocalDateTime fechamento=LocalDateTime.now().plusMinutes(1);
    	 return ResponseEntity.status(HttpStatus.CREATED).build().ok(service.criarNovaSessao(request,fechamento));
    	
    }
    @SuppressWarnings("static-access")
	@PostMapping("/votar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Votado", 
    			  nickname = "Voted", 
    			  notes = "Votar", 
    			  response = ResponseEntity.class, 
    			  tags = {
				 "Creation" })
    @ApiResponses({ 
    	@ApiResponse(code = 201, 
    			message = "Voto-concluido", 
    			response = ResponseEntity.class),
	@ApiResponse(code = 400, 
				message = "Voto-error"), })
    public ResponseEntity<Voto > votar(@PathVariable("id") String id, OpcaoVoto opcao ){
    	Long ids=Long.parseLong(id);
		return ResponseEntity.status(HttpStatus.CREATED).build().ok(service.votar(ids, opcao));
    	
    
    }
    @GetMapping("/sessoes/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(
    		value = "Encontrar todas as Sesspes", 
    		nickname = "find",
    		notes = "Encontrar todas as Sessoes existentes", 
    		response = ResponseEntity.class, 
    		tags = {"Find" })
    @ApiResponses({ 
    @ApiResponse(code = 200, message = "sessoes-encontradas", response = ResponseEntity.class),
	@ApiResponse(code = 404, message = "sessoes-nao-encontradas", response = ResponseEntity.class), })
    public ResponseEntity<Optional<Sessao>> getSessao(@PathVariable("id") String id){
    	Long ids=Long.parseLong(id);
    	
    	return ResponseEntity.ok(service.getSessaoId(ids));
    	
    }
    @GetMapping("/votos")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(
    		value = "Encontrar todos os Votos", 
    		nickname = "findAll",
    		notes = "Encontrar todas os Votos existentes", 
    		response = ResponseEntity.class, 
    		tags = {"FindAll" })
    @ApiResponses({ 
    	@ApiResponse(code = 200, message = "Votos-encontradas", response = ResponseEntity.class),
	@ApiResponse(code = 404, message = "Votos-nao-encontradas", response = ResponseEntity.class), })
    public ResponseEntity<Page<Voto>> getVotos(Pageable pageable){
    	Page<Voto> responses = service.getVotos(pageable);
    	return ResponseEntity.ok(responses);
    	
    }
    
    @GetMapping("/resultado")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(
    		value = "Mostrar Resultado", 
    		nickname = "findAll",
    		notes = "Encontrar Resultado", 
    		response = ResponseEntity.class, 
    		tags = {"FindAll" })
    @ApiResponses({ 
    	@ApiResponse(code = 200, message = "Resultado-encontrado", response = ResponseEntity.class),
	@ApiResponse(code = 404, message = "Resultado-nao-encontrado", response = ResponseEntity.class), })
    public ResponseEntity<String> getResultado(){
  
    	String responses = service.resultado();
    	return ResponseEntity.ok(responses);
    	

    }
	
	

}
