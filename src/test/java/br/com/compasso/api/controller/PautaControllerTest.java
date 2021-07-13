package br.com.compasso.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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

import br.com.compasso.api.model.request.PautaRequest;
import br.com.compasso.api.model.response.PautaResponse;
import br.com.compasso.api.persistence.domain.Pauta;
import br.com.compasso.api.persistence.repository.PautaRepository;
import br.com.compasso.api.service.PautaService;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PautaControllerTest {
	private static final ObjectMapper MAPPER = new ObjectMapper();

	@Autowired
	MockMvc mockMvc;

	@MockBean
	private PautaRepository repository;

	@MockBean
	private PautaService service;

	@Test
	public void pautaCriadaTest() throws Exception {

		PautaRequest request = new PautaRequest();
		request.setDescricao("teste");
		request.setTitulo("titulo");
		PautaResponse response = new PautaResponse();
		response.setDescricao("teste");
		response.setTitulo("titulo");
	
		String json = MAPPER.writeValueAsString(response);

		when(this.service.criarNovaPauta(request)).thenReturn(response);
		MvcResult result = mockMvc.perform(post("/pauta").content(json).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		MockHttpServletResponse responses = result.getResponse();
		assertNotNull(responses);
		assertEquals(200, responses.getStatus());
	}

	@Test
	public void pautaCriadaTestErro() throws Exception {
		when(this.repository.save(any(Pauta.class))).thenReturn(null);
		MvcResult result = mockMvc.perform(post("/pauta").contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		MockHttpServletResponse response = result.getResponse();
		assertNotNull(response);
		assertEquals(400, response.getStatus());
	}


}
