package com.banco.DTOs;

import java.time.LocalDate;

public record ClienteDTO(String nome , String cpf,String telefone,String email,LocalDate data_nascimento) {

    
}
