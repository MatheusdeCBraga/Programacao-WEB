package br.edu.iff.bsi.Pizzaria.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;

@Entity
public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private int quantidade_de_itens;

	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name = "pizza_id")
	private Pizza pizza;

	public ItemPedido() {

	}

	public ItemPedido(Long id, int quantidade_de_itens, Pizza pizza) {
		super();
		this.id = id;
		this.quantidade_de_itens = quantidade_de_itens;
		this.pizza = pizza;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public int getQuantidade_de_itens() {
		return quantidade_de_itens;
	}

	public void setQuantidade_de_itens(int quantidade_de_itens) {
		this.quantidade_de_itens = quantidade_de_itens;
	}

	public void setSabor(String sabor) {
		// TODO Auto-generated method stub

	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}
