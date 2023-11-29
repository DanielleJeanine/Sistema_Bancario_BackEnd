package com.banco.banco.entities;

import com.banco.banco.enums.TipoDeTransferencia;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Transferencia extends Operacao {

    private Long id;
    private Conta contaOrigem;
    private Conta contaDestino;
    private TipoDeTransferencia tipo;
    
}
