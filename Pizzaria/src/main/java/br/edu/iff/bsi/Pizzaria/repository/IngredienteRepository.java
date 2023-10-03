package br.edu.iff.bsi.Pizzaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.iff.bsi.Pizzaria.entities.Ingrediente;
import br.edu.iff.bsi.Pizzaria.entities.Pizza;
import jakarta.transaction.Transactional;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
   
}

