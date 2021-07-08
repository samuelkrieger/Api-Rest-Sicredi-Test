package br.com.compasso.api.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.compasso.api.persistence.domain.Voto;

public interface VotoRepository extends JpaRepository<Voto, Long> {

	@Query("SELECT p from Voto p where p.opcaoVoto = 1  ")
	List<Voto> findAllOpcaoVotoSim();
	
	@Query("SELECT p from Voto p where p.opcaoVoto = 0  ")
	List<Voto> findAllOpcaoVotoNao();
}
