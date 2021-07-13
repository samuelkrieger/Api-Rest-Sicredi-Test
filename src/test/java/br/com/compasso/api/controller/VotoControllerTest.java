package br.com.compasso.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.compasso.api.persistence.domain.OpcaoVoto;
import br.com.compasso.api.persistence.domain.Pauta;
import br.com.compasso.api.persistence.domain.Sessao;
import br.com.compasso.api.persistence.domain.Voto;
import br.com.compasso.api.persistence.repository.SessaoRepository;
import br.com.compasso.api.service.VotoService;


@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VotoControllerTest {
	private static final ObjectMapper MAPPER = new ObjectMapper();

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private VotoService service;
	
	@MockBean
	private SessaoRepository repository;
	
	@Test
	public void votoCriadoTest() throws Exception {
		
		Voto voto= new Voto();
		voto.setOpcaoVoto(OpcaoVoto.SIM);
		voto.setSessao(
				new Sessao(
						LocalDateTime.now(),
						LocalDateTime.now().plusMinutes(1),
						new Pauta("teste","pauta")));
		voto.setDataHora(LocalDateTime.now());
		String json = MAPPER.writeValueAsString(voto);

		when(this.service.votar(1L, OpcaoVoto.SIM)).thenReturn(voto);
		MvcResult result = mockMvc.perform(post("/voto/1").content(json)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
				
		MockHttpServletResponse response = result.getResponse();
		assertNotNull(response);
		assertEquals(200, response.getStatus());
		 
		
	}

}
