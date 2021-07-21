package br.com.compasso.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.api.persistence.domain.OpcaoVotoEntity;
import br.com.compasso.api.persistence.domain.VotoEntity;
import br.com.compasso.api.service.VotoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "voto")
@RequestMapping("/voto")
public class VotoResource {
	
	@Autowired
	private VotoService service;
	
	@PostMapping("/{id}")
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
    public ResponseEntity<VotoEntity > votar(@PathVariable("id") String id, OpcaoVotoEntity opcao ){
    	Long ids=Long.parseLong(id);
		return ResponseEntity.ok(service.votar(ids, opcao));
    	
    
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
    public ResponseEntity<List<VotoEntity>> getVotos(){
    	List<VotoEntity> responses = service.getAll();
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
