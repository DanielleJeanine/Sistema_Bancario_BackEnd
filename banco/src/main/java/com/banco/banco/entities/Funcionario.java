package com.banco.banco.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Funcionario extends Pessoa {

    private Long id;
    private String login;
    private String senha;
    private String ctps;

    
}
