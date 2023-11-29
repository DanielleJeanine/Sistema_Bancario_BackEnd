package com.banco.banco.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Cliente extends Pessoa {

    private Long id;
    private String login;
    private String senha;
    private Funcionario gerente;

    
}
