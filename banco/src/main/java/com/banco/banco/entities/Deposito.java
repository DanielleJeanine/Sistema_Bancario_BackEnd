package com.banco.banco.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Deposito extends Operacao {

    private Long id;
    private Conta contaDestino;
    
}
