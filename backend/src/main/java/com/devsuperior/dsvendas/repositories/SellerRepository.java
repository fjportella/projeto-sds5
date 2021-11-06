package com.devsuperior.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsvendas.entities.Seller;

// Implenta por padrão as opções Inserir, Alterar, Deletar as informações do Banco
public interface SellerRepository extends JpaRepository<Seller, Long> {



}
