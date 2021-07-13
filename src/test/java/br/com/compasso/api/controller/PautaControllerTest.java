package br.com.compasso.api.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.compasso.api.persistence.domain.Pauta;
import br.com.compasso.api.persistence.repository.PautaRepository;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PautaControllerTest {
	
	 private static final ObjectMapper MAPPER = new ObjectMapper();
	 
	 @Autowired
	 MockMvc mockMvc;
	 
	 @MockBean
	 private PautaRepository repository;
	 
	 @Test
	 public void pautaTestCriacao()throws Exception {
		 Pauta pauta = new Pauta();
		 pauta.setDescricao("pauta teste");
		 pauta.setTitulo("pauta");
		 
		 String json = MAPPER.writeValueAsString(pauta);
		 
	 }
	 
	 
	 
}
	 
	 
