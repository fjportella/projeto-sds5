package com.devsuperior.dsvendas.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


// Os nomes das tabelas e campos tem que ser os mesmos do arquivo import.sql
@Entity
@Table(name = "tb_sellers")
public class Seller {
	
	@Id  //indica a chave
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //indica que o ID é auto-incremento
	private Long id;
	private String name;
	
	// representa que um vendedor pode ter mais de 1 venda
	// neste caso é criada uma coleção
	@OneToMany(mappedBy = "seller")  // faz a ligação com a tabela seller
	private List<Sale> sales = new ArrayList<>();
	
	public Seller() {
		
	}

	public Seller(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Sale> getSales() {
		return sales;
	}
	
	
	
	

}
