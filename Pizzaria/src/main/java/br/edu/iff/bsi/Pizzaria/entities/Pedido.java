package br.edu.iff.bsi.Pizzaria.entities;

import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataDoPedido;

	@Column(nullable = false, unique = true)
	private String numeroPedido;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ItemPedido> itensPedido = new ArrayList<>();

	@OneToOne(mappedBy = "pedido")
	private Entrega entrega;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public Date getDataDoPedido() {
		return dataDoPedido;
	}

	public void setDataDoPedido(Date dataDoPedido) {
		this.dataDoPedido = dataDoPedido;
	}

	// public List<ItemPedido> getItensPedido() {
	// return itensPedido;
	// }

	// public void setItensPedido(List<ItemPedido> itensPedido) {
	// this.itensPedido = itensPedido;
	// }
	
	 public List<ItemPedido> getItensPedido() {
	        return itensPedido;
	    }

	    public void setItensPedido(List<ItemPedido> itensPedido) {
	        this.itensPedido = itensPedido;
	    }

	    public void adicionarItemPedido(ItemPedido itemPedido) {
	        itemPedido.setPedido(this); // Associe o pedido ao itemPedido
	        itensPedido.add(itemPedido);
	    }

	    public void removerItemPedido(ItemPedido itemPedido) {
	        itensPedido.remove(itemPedido);
	        itemPedido.setPedido(null); // Remova a associação do itemPedido com o pedido
	    }

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
