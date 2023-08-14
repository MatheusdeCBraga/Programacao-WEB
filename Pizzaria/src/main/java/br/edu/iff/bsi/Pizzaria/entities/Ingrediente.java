package br.edu.iff.bsi.Pizzaria.entities;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Ingrediente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private int quantidadeEstoque;
	@Column(nullable = false)
	private double preco;
	
	@ManyToMany(mappedBy = "ingredientes")
	private List<Pizza> pizzas = new ArrayList<>();
	
	public Ingrediente(){
		
	}
	
	public Ingrediente(long ultimoId, String nome, int quantidadeEstoque, double preco) {
		super();
		this.id = ultimoId;
		this.nome = nome;
		this.quantidadeEstoque = quantidadeEstoque;
		this.preco = preco;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(long ultimoId) {
		this.id = ultimoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	private Ingrediente findIngredienteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
	    return "Ingrediente{" +
	            "id=" + id +
	            ", nome='" + nome + '\'' +
	            ", quantidadeEstoque=" + quantidadeEstoque +
	            ", preco=" + preco +
	            '}';
	}
}
