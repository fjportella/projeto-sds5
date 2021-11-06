package com.devsuperior.dsvendas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {

	// criando repositorio
	@Autowired
	private SellerRepository repository;
	
	// Método para retornar uma lista de Seller
	public List<SellerDTO> findAll(){
		
		List<Seller> result = repository.findAll();
		
		// .map converte coleção original para outra coleção, que no caso é a SellerDTO
		// para cada X da lista original eu quero criar um outro objeto passando o X como argumento
		// collect converte novamente em ListaSellerService.java
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
		
		
	}
	
	
	
	
}
