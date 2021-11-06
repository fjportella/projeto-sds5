package com.devsuperior.dsvendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	// criando repositorio
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	// Método para retornar uma lista de Seller
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll(); // traz para a memória todos registros
		Page<Sale> result = repository.findAll(pageable);
		// .map converte coleção original para outra coleção, que no caso é a SellerDTO
		// para cada X da lista original eu quero criar um outro objeto passando o X como argumento
		// collect converte novamente em ListaSellerService.java
		return result.map(x -> new SaleDTO(x));
		
	}
		
		// usado para o agrupamento de valores por vendedor
		@Transactional(readOnly = true)
		public List<SaleSumDTO> amountGroupedBySeller(){
			return repository.amountGroupedBySeller();	

	}
		
		
		// usado para o agrupamento de valores por vendedor
		@Transactional(readOnly = true)
		public List<SaleSuccessDTO> successGroupedBySeller(){
		return repository.successGroupedBySeller();	

			}
	
	
	
	
}
