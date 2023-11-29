package com.banco.banco.entities;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Saque extends Operacao {
    
    private Long id;
    private Conta contaOrigem;
}
