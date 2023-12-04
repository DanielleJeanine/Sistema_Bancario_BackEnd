package com.banco.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public  List<Endereco> getAllEnderecos(){
        List<Endereco> enderecos = enderecoRepository.findAll();
        return enderecos;
    }

    public Endereco getEnderecoById(Long id){
        Endereco endereco = enderecoRepository.findById(id).orElse(null);
        return endereco;
    }

    public Endereco saveEnderecoCliente(Endereco endereco, Long idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
        
        if (cliente != null) {
            endereco.setCliente(cliente);
            Endereco enderecoNovo = enderecoRepository.save(endereco);
            return enderecoNovo;
        } else {
            return null; 
        }
    }
    public Endereco saveEnderecoFuncionario(Endereco endereco, Long id){
        Funcionario funcionario = funcionarioRepository.findById(id).orElse(null);
        Endereco enderecoNovo = enderecoRepository.save(endereco);
        enderecoNovo.setFuncionario(funcionario);
        enderecoRepository.save(enderecoNovo);
        return enderecoNovo;
    }

    public Endereco updateEndereco(Endereco endereco,Long id){
        if(endereco == null ) return null;

       try {
        BeanUtils.copyProperties(this, endereco);
    } catch (Exception e) {
        e.printStackTrace();
    }
        Endereco saveEndereco = enderecoRepository.save(endereco);
        return saveEndereco;
    }

    public Endereco deleteEndereco(Long id ){
        Endereco endereco = enderecoRepository.findById(id).orElse(null);
        enderecoRepository.delete(endereco);
        
        return endereco;
        
    }

    
}


