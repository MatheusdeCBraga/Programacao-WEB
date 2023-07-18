package br.edu.iff.bsi.Pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.iff.bsi.Pizzaria.entities.*;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long>{

}
