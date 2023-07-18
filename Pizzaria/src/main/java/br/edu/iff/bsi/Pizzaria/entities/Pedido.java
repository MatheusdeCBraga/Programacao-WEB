package br.edu.iff.bsi.Pizzaria.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private int numeroPedido;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar dataDoPedido;

    @OneToMany
    @JoinColumn(name = "id_pedido")
    private List<ItemPedido> itensPedido;

    @ManyToOne
    private Cliente cliente;
	
	public Pedido(Long id, int numeroPedido, Calendar dataDoPedido, List<ItemPedido> itensPedido, Cliente cliente) {
		super();
		this.id = id;
		this.numeroPedido = numeroPedido;
		this.dataDoPedido = dataDoPedido;
		this.itensPedido = itensPedido;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public Calendar getDataDoPedido() {
		return dataDoPedido;
	}

	public void setDataDoPedido(Calendar dataDoPedido) {
		this.dataDoPedido = dataDoPedido;
	}

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
}
