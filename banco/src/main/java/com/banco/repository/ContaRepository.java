package com.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.entities.conta.Conta;

public interface ContaRepository extends JpaRepository<Conta,Long>{

}
