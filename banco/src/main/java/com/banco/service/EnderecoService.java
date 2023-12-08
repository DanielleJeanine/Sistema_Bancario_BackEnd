package com.banco.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.DTOs.EnderecoDTO;
import com.banco.entities.Cliente;
import com.banco.entities.Endereco;
import com.banco.entities.Funcionario;
import com.banco.repository.ClienteRepository;
import com.banco.repository.EnderecoRepository;
import com.banco.repository.FuncionarioRepository;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Endereco> getAllEnderecos() {
        List<Endereco> enderecos = enderecoRepository.findAll();
        return enderecos;
    }

    public EnderecoDTO getEnderecoClienteById(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        Endereco endereco = cliente.getEnderecoCliente();
        if (endereco != null) {
            EnderecoDTO enderecoDTO = endereco.enderecoDTO(endereco);
            return enderecoDTO;
        } else {
            return null;
        }
    }
    public EnderecoDTO getEnderecoFuncionarioById(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElse(null);
        Endereco endereco = funcionario.getEnderecoFuncionario();
        if (endereco != null) {
            EnderecoDTO enderecoDTO = endereco.enderecoDTO(endereco);
            return enderecoDTO;
        } else {
            return null;
        }
    }

    public EnderecoDTO saveEnderecoCliente(Endereco endereco, Long idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);

        if (cliente != null) {
            cliente.setEnderecoCliente(endereco);
            Endereco enderecoNovo = enderecoRepository.save(endereco);
            EnderecoDTO enderecoDTO = enderecoNovo.enderecoDTO(enderecoNovo);
            return enderecoDTO;
        } else {
            return null;
        }
    }

    public Endereco saveEnderecoFuncionario(Endereco endereco, Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElse(null);
        Endereco enderecoNovo = enderecoRepository.save(endereco);
        funcionario.setEnderecoFuncionario(enderecoNovo);
        enderecoRepository.save(enderecoNovo);
        return enderecoNovo;
    }

    public EnderecoDTO updateEnderecoCliente(Endereco endereco, Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);

        if (endereco != null && cliente != null) {
            try {
                BeanUtils.copyProperties(cliente.getEnderecoCliente(), endereco);
            } catch (Exception e) {
                e.printStackTrace();
            }
            endereco.setCliente(cliente);
            Endereco saveEndereco = enderecoRepository.save(endereco);

            EnderecoDTO enderecoDTO = saveEndereco.enderecoDTO(saveEndereco);
            return enderecoDTO;
        }
        return null;

    }

    public EnderecoDTO updateEnderecoFuncionario(Endereco endereco, Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElse(null);

        if (endereco != null && funcionario != null) {
            try {
                BeanUtils.copyProperties(funcionario.getEnderecoFuncionario(), endereco);
            } catch (Exception e) {
                e.printStackTrace();
            }
            endereco.setFuncionario(funcionario);
            Endereco saveEndereco = enderecoRepository.save(endereco);

            EnderecoDTO enderecoDTO = saveEndereco.enderecoDTO(saveEndereco);
            return enderecoDTO;
        }
        return null;
    }

    public EnderecoDTO deleteEndereco(Long id) {
        Endereco endereco = enderecoRepository.findById(id).orElse(null);
        enderecoRepository.delete(endereco);
        EnderecoDTO enderecoDTO = endereco.enderecoDTO(endereco);

        return enderecoDTO;

    }

}
