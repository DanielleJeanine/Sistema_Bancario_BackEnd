package com.banco.entities.conta;


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
public class Saque extends Operacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "contaOrigem",foreignKey = @ForeignKey(name = "contaOrigem_Fkey"))
    private Conta contaOrigem;
    public Saque(){}
    // public Saque(Saque saque) {
    //     this.setValor(saque.getValor());
    //     this.
    // }
}
