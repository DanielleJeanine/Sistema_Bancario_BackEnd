package com.banco.entities;

import java.util.List;

import com.banco.DTOs.ClienteDTO;
import com.banco.DTOs.EnderecoDTO;
import com.banco.entities.conta.Conta;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "titularDaConta")
    private List<Conta> contas;
    @ManyToOne
    @JoinColumn(name = "funcionario",foreignKey = @ForeignKey(name = "funcionario_Fkey"))
    private Funcionario gerente;
    @OneToOne
    @JoinColumn(name = "enderecoCliente", foreignKey = @ForeignKey(name = "endereco_Fkey"))
    private Endereco enderecoCliente;
    public ClienteDTO clienteDTO(Cliente cliente){
        EnderecoDTO endereco = cliente.enderecoDTO(cliente.getEnderecoCliente());
        ClienteDTO clienteDTO = new ClienteDTO(cliente.getNome(),cliente.getCpf(),
        cliente.getTelefone(),cliente.getEmail(),cliente.getDataDeNascimento(),endereco);
         return clienteDTO;
    }
    public EnderecoDTO enderecoDTO(Endereco endereco){
        EnderecoDTO enderecoDTO = new EnderecoDTO(endereco.getCep(),endereco.getEstado(),endereco.getCidade(),
        endereco.getBairro(),endereco.getRua(),endereco.getComplemento());
        return enderecoDTO;
    }
}
