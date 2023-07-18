package br.edu.iff.bsi.Pizzaria.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cargo;
	@Column(nullable = false)
	private float salario;
	
	
	public Funcionario(Long id, String nome, String cargo, float salario) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
		this.salario = salario;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public float getSalario() {
		return salario;
	}


	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	
	
	
}
