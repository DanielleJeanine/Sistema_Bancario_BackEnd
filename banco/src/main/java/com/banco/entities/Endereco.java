package com.banco.entities;


import com.banco.DTOs.EnderecoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    @OneToOne(mappedBy = "enderecoFuncionario")
    private Funcionario funcionario;
    @OneToOne(mappedBy = "enderecoCliente")
    private Cliente cliente;
    //bairro,cep,rua,numero,complemplemento,estado,cidade,
    public EnderecoDTO enderecoDTO(Endereco endereco){
        EnderecoDTO enderecoDTO = new EnderecoDTO(endereco.getCep(),endereco.getEstado(),endereco.getCidade(),
        endereco.getBairro(),endereco.getRua(),endereco.getComplemento());
        return enderecoDTO;
    }
}
