package br.edu.iff.bsi.Pizzaria.entities;

import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
//    @Temporal(TemporalType.TIMESTAMP)
//	private Calendar dataDoPedido;

    @ManyToMany
	@JoinTable(name = "pedido_pizza",
				joinColumns = @JoinColumn(name = "pedido_id"),
				inverseJoinColumns = @JoinColumn(name = "pizza_id"))
	private List<Pizza> pizzas;
    
    @Column(nullable = false)
    private String formaDePagamento;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Funcionario funcionario;
    

    
    public Pedido() {
    	
    }
    

    public Pedido(Long id, List<Pizza> pizzas, String formaDePagamento, Cliente cliente,
			Funcionario funcionario) {
		super();
		this.id = id;
		this.formaDePagamento = formaDePagamento;
		this.cliente = cliente;
		this.pizzas = pizzas;
		this.funcionario = funcionario;
		
	}


//	public Calendar getDataDoPedido() {
//        return dataDoPedido;
//    }
//
//    public void setDataDoPedido(Calendar dataDoPedido) {
//        this.dataDoPedido = dataDoPedido;
//    }


    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

  
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


	public List<Pizza> getPizza() {
		return pizzas;
	}


	public void setPizza(List<Pizza> pizza) {
		this.pizzas = pizza;
	}

	
	



	
    
    
}
