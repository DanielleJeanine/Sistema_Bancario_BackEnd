package com.banco.entities;

import java.time.LocalDate;


import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class Pessoa {
    private String nome;
    private LocalDate dataDeNascimento;
    private String cpf;
    private String email;
    private String telefone;
    private Boolean ativo;
}
