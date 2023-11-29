package com.banco.banco.entities;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Pessoa {
    private String nome;
    private LocalDate dataDeNascimento;
    private String cpf;
    private String email;
    private String telefone;
    private Endereco endereco;
    private Boolean ativo;
}
