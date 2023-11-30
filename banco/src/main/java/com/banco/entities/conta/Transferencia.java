package com.banco.entities.conta;

import com.banco.enums.TipoDeTransferencia;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "saque")
public class Transferencia extends Operacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "transfereciaOrigem", foreignKey = @ForeignKey(name = "transfereciaOrigem_Fkey"))
    private Conta contaOrigem;
    @ManyToOne
    @JoinColumn(name = "transferenciaDestino", foreignKey = @ForeignKey(name = "transferenciaDestino_Fkey"))
    private Conta contaDestino;
    private TipoDeTransferencia tipo;
    
}
