package br.com.compasso.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import br.com.compasso.api.model.request.PautaRequest;
import br.com.compasso.api.model.response.SessaoResponse;
import br.com.compasso.api.persistence.domain.Pauta;
import br.com.compasso.api.persistence.repository.SessaoRepository;
import br.com.compasso.api.service.SessaoService;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SessaoControllerTest {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	@Autowired
	MockMvc mockMvc;

	@MockBean
	private SessaoService service;

	@MockBean
	private SessaoRepository repository;

	@Test
	public void sessaoCriadaTest() throws Exception {

		SessaoResponse response = new SessaoResponse();
		response.setDataAbertura(LocalDateTime.now());
		response.setDataFechamento(LocalDateTime.now().plusMinutes(1));
		response.setPauta(new Pauta("teste", "pauta"));
		PautaRequest request = new PautaRequest();
		request.setDescricao("teste");
		request.setTitulo("titulo");
		String json = MAPPER.writeValueAsString(response);

		when(this.service.criarNovaSessao(request, LocalDateTime.now())).thenReturn(response);
		MvcResult result = mockMvc.perform(post("/sessao")
				.content(json)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		MockHttpServletResponse responses = result.getResponse();
		assertNotNull(response);
		assertEquals(200, responses.getStatus());

	}


	@Test
	public void sessaoGetNotFoundTest() throws Exception {
		

		when(this.service.getSessaoId(1L)).thenReturn(null);
		MvcResult result = mockMvc.perform(get("/sessoes/1")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		MockHttpServletResponse responses = result.getResponse();
		assertNotNull(responses);
		assertEquals(404, responses.getStatus());

	}

}
