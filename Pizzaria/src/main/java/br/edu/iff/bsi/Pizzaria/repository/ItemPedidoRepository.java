package br.edu.iff.bsi.Pizzaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.iff.bsi.Pizzaria.entities.*;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>{

	@Query(value = "SELECT * FROM ITEMPEDIDO", nativeQuery = true)
	List<ItemPedido> selectAllItemPedido();
}
