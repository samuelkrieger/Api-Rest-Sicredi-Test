package br.com.compasso.api.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.api.persistence.domain.Pauta;

public interface PautaRepository extends JpaRepository<Pauta, Long>{

}
