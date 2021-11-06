package com.devsuperior.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsvendas.entities.Sale;

// Implenta por padrão as opções Inserir, Alterar, Deletar as informações do Banco
public interface SaleRepository extends JpaRepository<Sale, Long> {



}
