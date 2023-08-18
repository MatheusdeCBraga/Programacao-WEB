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
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;

@Entity
@NamedEntityGraph(name = "Pizza.ingredientes", attributeNodes = @NamedAttributeNode("ingredientes"))
public class Pizza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String sabor;
	@Column(nullable = false)
	private float preco;
	@OneToMany(mappedBy = "pizza")
    private List<ItemPedido> itemPedidos = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "pizza_ingredientes", joinColumns = @JoinColumn(name = "pizza_id"), inverseJoinColumns = @JoinColumn(name = "ingrediente_id"))
    private List<Ingrediente> ingredientes = new ArrayList<>();

	@Override
	public String toString() {
		return "Pizza{" + "id=" + id + '\'' + ", sabor='" + sabor + '\'' + ", preco=" + preco + ", ingredientes="
				+ ingredientes + '}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public List<Long> getIngredientesIds() {
		List<Long> ingredientesIds = new ArrayList<>();
		for (Ingrediente ingrediente : this.ingredientes) {
			ingredientesIds.add(ingrediente.getId());
		}
		return ingredientesIds;
	}

	public Object getTamanho() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setTamanho(Object tamanho) {
		// TODO Auto-generated method stub

	}

}
