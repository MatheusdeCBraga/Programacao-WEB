package br.edu.iff.bsi.Pizzaria.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column(nullable = false)
	    private String nome;
	    @Column(nullable = false)
	    private String sobrenome;
	    @Column(nullable = false)
	    private String cargo;
	    @Column(nullable = false)
	    private double salario;
	    @Column(nullable = false)
	    private String email;
	    @Column(nullable = false)
	    private String password;
	    
	    

	    public Funcionario() {
	    	
	    }

	    public Funcionario(Long id, String nome, String sobrenome, String cargo, double salario, String email, String password) {
			super();
			this.id = id;
			this.nome = nome;
			this.sobrenome = sobrenome;
			this.cargo = cargo;
			this.salario = salario;
			this.email = email;
			this.password = password;
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

	    public double getSalario() {
	        return salario;
	    }

	    public void setSalario(double salario) {
	        this.salario = salario;
	    }

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getSobrenome() {
			return sobrenome;
		}

		public void setSobrenome(String sobrenome) {
			this.sobrenome = sobrenome;
		}
		
	    
	}
	
	
	

