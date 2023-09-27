package br.edu.iff.bsi.Pizzaria.repository;

import br.edu.iff.bsi.Pizzaria.entities.Pedido;
import br.edu.iff.bsi.Pizzaria.entities.Pizza;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
