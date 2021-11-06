package com.devsuperior.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;

// Implenta por padrão as opções Inserir, Alterar, Deletar as informações do Banco
public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	// Método para agrupar as vendas por nome do vendedor
	
	@Query("SELECT new com.devsuperior.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) " 
		+  "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	
	// Método para calcular taxa de sucesso
	
		@Query("SELECT new com.devsuperior.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited) , SUM(obj.deals)) " 
			+  "FROM Sale AS obj GROUP BY obj.seller")
		List<SaleSuccessDTO> successGroupedBySeller();



}
