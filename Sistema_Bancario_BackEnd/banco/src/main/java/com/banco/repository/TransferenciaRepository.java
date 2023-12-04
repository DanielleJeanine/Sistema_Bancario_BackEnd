package com.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.entities.conta.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia,Long> {
    

}
