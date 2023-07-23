package br.edu.iff.bsi.Pizzaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.iff.bsi.Pizzaria.entities.*;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query(value = "SELECT * FROM CLIENTE", nativeQuery = true)
	List<Cliente> selectAllCliente();
	@Query(value = "SELECT C.ID, C.NOME, E.ID, E.RUA ,E.NUMERO, E.BAIRRO, E.CIDADE, E.ESTADO, E.CEP, E.STATUSENTREGA,E.FORMAPAGAMENTO "
			+ "FROM CLIENTE C " + "JOIN ENDERECO E ON C.ID_ENDERECO = E.ID "
			+ "JOIN CARTEIRA CA ON C.ID_CARTEIRA = CA.ID", nativeQuery = true)
	List<String> selectAllInfoCliente();

}
