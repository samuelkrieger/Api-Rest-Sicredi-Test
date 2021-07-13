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
	public void pautaCriadaTest() throws Exception {

		Pauta pauta = new Pauta("teste", "pauta");
		String json = MAPPER.writeValueAsString(pauta);

		when(this.repository.save(any(Pauta.class))).thenReturn(pauta);
		MvcResult result = mockMvc.perform(post("/pauta").content(json).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		MockHttpServletResponse response = result.getResponse();
		assertNotNull(response);
		assertEquals(200, response.getStatus());
	}

	@Test
	public void pautaEncontradaTest() throws Exception {
			
	}
}
