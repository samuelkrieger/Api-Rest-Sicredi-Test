package br.com.compasso.api.service.mapper.response;

import org.springframework.stereotype.Component;

import br.com.compasso.api.model.response.SessaoResponse;
import br.com.compasso.api.persistence.domain.Sessao;
import br.com.compasso.api.service.Mapper;

@Component
public class SessaoMapperResponse implements Mapper<Sessao,SessaoResponse> {
	
	@Override
    public SessaoResponse map(Sessao input) {
        if(input == null){
            return null;
        }

        SessaoResponse  response = new SessaoResponse();
        response.setDataAbertura(input.getDataAbertura());
        response.setDataFechamento(input.getDataFechamento());
        response.setPauta(input.getPauta());
 
        
     
     

        return response;
    } }
