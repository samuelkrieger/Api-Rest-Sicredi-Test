package br.com.compasso.api.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.compasso.api.persistence.domain.VotoEntity;

public interface VotoRepository extends JpaRepository<VotoEntity, Long> {

	@Query("SELECT p from Voto p where p.opcaoVoto = 1  ")
	List<VotoEntity> findAllOpcaoVotoSim();
	
	@Query("SELECT p from Voto p where p.opcaoVoto = 0  ")
	List<VotoEntity> findAllOpcaoVotoNao();
}
