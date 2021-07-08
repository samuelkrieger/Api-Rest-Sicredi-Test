package br.com.compasso.api.service.mapper.request;

import org.springframework.stereotype.Component;

import br.com.compasso.api.model.request.SessaoRequest;
import br.com.compasso.api.persistence.domain.Sessao;
import br.com.compasso.api.service.Mapper;

@Component
public class SessaoMapperRequest  implements Mapper<SessaoRequest, Sessao> {
	
	@Override
    public Sessao map(SessaoRequest input) {
        if(input == null){
            return null;
        }

        Sessao  sessao=new Sessao();
        sessao.setDataAbertura(input.getDataAbertura());
        sessao.setDataFechamento(input.getDataFechamento());
        sessao.setPauta(input.getPauta());
    
     

        return sessao;
    } 

}