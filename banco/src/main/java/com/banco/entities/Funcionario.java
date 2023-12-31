package com.banco.entities;

import java.util.List;

import com.banco.DTOs.ClienteDTO;
import com.banco.DTOs.EnderecoDTO;
import com.banco.DTOs.FuncionarioDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String senha;
    private String ctps;
    @OneToMany(mappedBy = "gerente")
    private List<Cliente> clientes;
    @OneToOne
    @JoinColumn(name = "enderecoFuncionario", foreignKey = @ForeignKey(name = "endereco_Fkey"))
    private Endereco enderecoFuncionario;

    public FuncionarioDTO funcionarioDTO(Funcionario funcionario){
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO(funcionario.getNome(), funcionario.getCpf(),
         funcionario.getTelefone(), funcionario.getEmail());
         return funcionarioDTO;
    }
    //String nome, String cpf, String gerente, String telefone, String email, LocalDate data_nascimento
    public ClienteDTO clienteDTO(Cliente cliente){
        EnderecoDTO endereco = cliente.enderecoDTO(cliente.getEnderecoCliente());
        ClienteDTO clienteDTO = new ClienteDTO(cliente.getId(),cliente.getNome(),cliente.getCpf(),
        cliente.getTelefone(),cliente.getEmail(),cliente.getDataDeNascimento(),endereco);
         return clienteDTO;
    }
    public EnderecoDTO enderecoDTO(Endereco endereco){
        EnderecoDTO enderecoDTO = new EnderecoDTO(endereco.getCep(),endereco.getEstado(),endereco.getCidade(),
        endereco.getBairro(),endereco.getRua(),endereco.getComplemento());
        return enderecoDTO;
    }
}
