package com.banco.banco.entities;

import lombok.Data;

@Data
public class Endereco {

    private Long id;
    private String cep;
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
}
