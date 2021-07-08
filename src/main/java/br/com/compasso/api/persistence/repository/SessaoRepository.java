package br.com.compasso.api.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.api.persistence.domain.Pauta;
import br.com.compasso.api.persistence.domain.Sessao;

public interface SessaoRepository extends JpaRepository<Sessao, Long>{
	 Sessao findByPauta(Optional<Pauta> pauta);
}
