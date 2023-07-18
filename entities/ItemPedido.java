package br.edu.iff.bsi.Pizzaria.entities;
import java.io.Serializable;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private int quantidade;
	@Column(nullable = false)
	private String nomeItem;
	@Column(nullable = false)
	private float preco;
	@Column(nullable = false)
	private Pizza pizza;
	
	@ManyToOne
	private Pedido pedido;
	
	
	public ItemPedido(Long id, int quantidade, String nomeItem, float preco, Pizza pizza) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.nomeItem = nomeItem;
		this.preco = preco;
		this.pizza = pizza;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public String getNomeItem() {
		return nomeItem;
	}


	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}


	public float getPreco() {
		return preco;
	}


	public void setPreco(float preco) {
		this.preco = preco;
	}


	public Pizza getPizza() {
		return pizza;
	}


	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	
	
	

}
