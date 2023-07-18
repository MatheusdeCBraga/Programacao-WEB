package br.edu.iff.bsi.Pizzaria.entities;
import java.io.Serializable;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class Pizza implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String tamanho;
	@Column(nullable = false)
	private String sabor;
	@Column(nullable = false)
	private float preco;
	
	@OneToOne
	private ItemPedido itempedido;

	public Pizza(Long id, String tamanho, String sabor, float preco, ItemPedido itempedido) {
		super();
		this.id = id;
		this.tamanho = tamanho;
		this.sabor = sabor;
		this.preco = preco;
		this.itempedido = itempedido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public ItemPedido getItempedido() {
		return itempedido;
	}

	public void setItempedido(ItemPedido itempedido) {
		this.itempedido = itempedido;
	}
	
	
	

}
