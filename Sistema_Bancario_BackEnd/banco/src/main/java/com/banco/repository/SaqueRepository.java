package com.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.entities.conta.Saque;

public interface SaqueRepository extends JpaRepository<Saque,Long> {

}
