package com.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.entities.conta.Deposito;

public interface DepositoRepository extends JpaRepository<Deposito,Long> {

}
