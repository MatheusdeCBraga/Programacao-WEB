package br.edu.iff.bsi.Pizzaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.iff.bsi.Pizzaria.entities.*;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long>{

	@EntityGraph(value = "Pizza.ingredientes") 
	List<Pizza> findAll();
	
	Pizza findBySabor(String sabor);
}



