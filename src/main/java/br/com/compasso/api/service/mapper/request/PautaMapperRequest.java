package br.com.compasso.api.service.mapper.request;

import org.springframework.stereotype.Component;

import br.com.compasso.api.model.request.PautaRequest;
import br.com.compasso.api.persistence.domain.Pauta;
import br.com.compasso.api.service.Mapper;

@Component
public class PautaMapperRequest implements Mapper<PautaRequest, Pauta> {
	
	@Override
    public Pauta map(PautaRequest input) {
        if(input == null){
            return null;
        }

        Pauta pauta = new Pauta();
        pauta.setDescricao(input.getDescricao());
        pauta.setTitulo(input.getTitulo());
     

        return pauta;
    } 

}
