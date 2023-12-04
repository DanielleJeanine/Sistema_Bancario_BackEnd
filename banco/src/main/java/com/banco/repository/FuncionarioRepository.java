package com.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long>{
    
}
