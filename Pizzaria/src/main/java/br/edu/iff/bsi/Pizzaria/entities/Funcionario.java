package br.edu.iff.bsi.Pizzaria.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Size;

@Entity
public class Funcionario extends Pessoa {
	
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String sobrenome;
	@Column(unique=true)
	private String senha;
	@Column(nullable = false)
	private String telefone;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Size(min=1,max=60,message="Tem que ter entre 1 e 60 caractéres")
	@Column(length = 60)
		private String cargo;
	@Column(nullable = false)
	private float salario;
	@Column(nullable = false)
	private String email;
	

	public Funcionario(String nome, String sobrenome, String telefone, String senha, String cargo, float salario, String email) {
		super(nome, sobrenome, senha, telefone);
		this.cargo = cargo;
		this.salario=salario;
		this.email=email;
	}

	
	public Funcionario () {
		
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
}

