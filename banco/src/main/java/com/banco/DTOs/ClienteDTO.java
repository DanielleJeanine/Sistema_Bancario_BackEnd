package com.banco.DTOs;

import java.time.LocalDate;

import com.banco.entities.Endereco;

public record ClienteDTO(Long id,String nome , String cpf,String telefone,String email,LocalDate data_nascimento,EnderecoDTO endereco) {

    
}
