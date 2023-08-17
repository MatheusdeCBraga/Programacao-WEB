package br.edu.iff.bsi.Pizzaria.entities;

import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

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
    @Column(nullable = false)
    private Date dataDoPedido;

    @OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL)
    private List<Pizza> pizzas;
    @Column(nullable = false)
    private String formaDePagamento;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Funcionario funcionario;
    

    
    public Pedido() {
    	
    }
    

    public Pedido(Long id, Date dataDoPedido, List<Pizza> pizzas, String formaDePagamento, Cliente cliente,
			Funcionario funcionario) {
		super();
		this.id = id;
		this.dataDoPedido = dataDoPedido;
		this.pizzas = pizzas;
		this.formaDePagamento = formaDePagamento;
		this.cliente = cliente;
		this.funcionario = funcionario;
		
	}


	public Date getDataDoPedido() {
        return dataDoPedido;
    }

    public void setDataDoPedido(Date dataDoPedido) {
        this.dataDoPedido = dataDoPedido;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

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
    
//    public void adicionarPizza(Pizza pizza) {
//        pizzas.add(pizza);
//        pizza.setPedido(this); // Configura o relacionamento bidirecional
//    }
    
    
}
