package br.com.compasso.api.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.api.persistence.domain.VotoEntity;

public interface VotoRepository extends JpaRepository<VotoEntity, Long> {

	
}
