package br.edu.iff.bsi.Pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.iff.bsi.Pizzaria.entities.*;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	@Query(value = "SELECT * FROM COMPRA WHERE ID = ?1", nativeQuery = true)
	Pedido BuscarPeloId(Long id);

	@Query(value = "SELECT ID_CLIENTE FROM PEDIDO WHERE ID = ?1", nativeQuery = true)
	Long BuscarPeloIdCliente(Long id);

}
