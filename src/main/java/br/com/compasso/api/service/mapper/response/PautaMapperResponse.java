package br.com.compasso.api.service.mapper.response;

import org.springframework.stereotype.Component;


import br.com.compasso.api.model.response.PautaResponse;
import br.com.compasso.api.persistence.domain.Pauta;
import br.com.compasso.api.service.Mapper;
@Component
public class PautaMapperResponse implements Mapper<Pauta,PautaResponse> {
	
	@Override
    public PautaResponse map(Pauta input) {
        if(input == null){
            return null;
        }

        PautaResponse  pautaResponse = new PautaResponse();
        pautaResponse.setDescricao(input.getDescricao());
        pautaResponse.setTitulo(input.getTitulo());
     
     

        return pautaResponse;
    } }
