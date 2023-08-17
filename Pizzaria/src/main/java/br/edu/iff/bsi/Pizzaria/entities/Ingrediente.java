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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private int quantidadeDeEstoque;
    @Column(nullable = false)
    private double preco;

    public Ingrediente () {
    	
    }
    public Ingrediente(Long id, String nome, int quantidadeDeEstoque, double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidadeDeEstoque = quantidadeDeEstoque;
		this.preco = preco;
	}

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeDeEstoque() {
        return quantidadeDeEstoque;
    }

    public void setQuantidadeDeEstoque(int quantidadeDeEstoque) {
        this.quantidadeDeEstoque = quantidadeDeEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
