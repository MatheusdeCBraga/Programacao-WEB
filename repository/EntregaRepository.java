package br.edu.iff.bsi.Pizzaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.iff.bsi.Pizzaria.entities.*;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long>{

	@Query(value = "SELECT * FROM ENTREGA", nativeQuery = true)
	List<Entrega> selectAllEndereco();

	
}
