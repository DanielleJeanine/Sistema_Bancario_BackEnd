package com.banco.entities;

import java.util.List;

import com.banco.DTOs.ClienteDTO;
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
        ClienteDTO clienteDTO = new ClienteDTO(cliente.getNome(),cliente.getCpf(),
        cliente.getTelefone(),cliente.getEmail(),cliente.getDataDeNascimento());
         return clienteDTO;
    }
    
}
