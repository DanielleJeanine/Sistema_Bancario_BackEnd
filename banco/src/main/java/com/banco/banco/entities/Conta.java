package com.banco.banco.entities;

import lombok.Data;

@Data
public class Conta {
    
    private Long id;
    private String numeroDaConta;
    private Boolean statusAtivo;
    private String tipoDeConta;
    private Float saldo;
    private Cliente titularDaConta;

}
