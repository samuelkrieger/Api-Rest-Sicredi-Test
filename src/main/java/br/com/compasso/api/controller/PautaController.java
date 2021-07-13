package br.com.compasso.api.controller;

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

import br.com.compasso.api.model.request.PautaRequest;
import br.com.compasso.api.model.response.PautaResponse;
import br.com.compasso.api.persistence.domain.Pauta;
import br.com.compasso.api.service.PautaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "pauta")
@RequestMapping("/pauta")
public class PautaController {

	@Autowired
	private  PautaService service;

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

    	return ResponseEntity.ok(service.criarNovaPauta(request));
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
    	Pauta response = service.get(id);
    	return response.map(ResponseEntity::ok);
    }
    
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
    public ResponseEntity<List<Pauta>> getPautas(){
    	List<Pauta> responses = service.getAll();
    	return ResponseEntity.ok(responses);
    	
    }

	
    

	
	
	

}
