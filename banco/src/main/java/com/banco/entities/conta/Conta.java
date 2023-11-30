package com.banco.entities.conta;

import java.util.List;

import com.banco.entities.Cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "conta")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroDaConta;
    private Boolean statusAtivo;
    private String tipoDeConta;
    private Float saldo;
    @ManyToOne
    @JoinColumn(name = "cliente",foreignKey = @ForeignKey(name = "cliente_Fkey"))
    private Cliente titularDaConta;
    @OneToMany(mappedBy = "contaOrigem")
    private List<Saque> saques;
    @OneToMany(mappedBy = "contaDestino")
    private List<Deposito> depositos;
    @OneToMany(mappedBy = "contaOrigem")
    private List<Transferencia> transfereciasOrigem;
    @OneToMany(mappedBy = "contaDestino")
    private List<Transferencia> transfereciasDestino;


}
