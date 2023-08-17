package br.edu.iff.bsi.Pizzaria.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;

@Entity
@NamedEntityGraph(name = "Pizza.ingredientes", attributeNodes = @NamedAttributeNode("ingredientes"))
public class Pizza implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String sabor;

	@Column(nullable = false)
	private double preco;

	@OneToMany(mappedBy = "pizza")
	private List<ItemPedido> itemPedidos;
	
	

	@ManyToMany
	@JoinTable(name = "pizza_ingredientes", joinColumns = @JoinColumn(name = "pizza_id"), inverseJoinColumns = @JoinColumn(name = "ingrediente_id"))
	private List<Ingrediente> ingredientes;

	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;

	@Column(nullable = false)
	private String tamanhoDaPizza;

	public Pizza() {

	}

	public Pizza(Long id, String sabor, double preco, List<ItemPedido> itemPedidos, List<Ingrediente> ingredientes,
			Pedido pedido, String tamanhoDaPizza) {
		super();
		this.id = id;
		this.sabor = sabor;
		this.preco = preco;
		this.itemPedidos = itemPedidos;
		this.ingredientes = ingredientes;
		this.pedido = pedido;
		this.tamanhoDaPizza = tamanhoDaPizza;
	}


	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTamanhoDaPizza() {
		return tamanhoDaPizza;
	}

	public void setTamanhoDaPizza(String tamanhoDaPizza) {
		this.tamanhoDaPizza = tamanhoDaPizza;
	}
}
