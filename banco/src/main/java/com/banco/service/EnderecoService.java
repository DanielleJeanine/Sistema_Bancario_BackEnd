package com.banco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.entities.Endereco;
import com.banco.repository.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    public Optional<Endereco> find(Long id){
        return enderecoRepository.findById(id);
    }

    public List<Endereco>  listAll(){
        return enderecoRepository.findAll();
    }

    public Endereco add (Endereco endereco){
        endereco = enderecoRepository.save(endereco);
        return new Endereco();
    }

    public Endereco update (Long id, Endereco endereco){
        if (enderecoRepository.existsById(id)) {
            endereco.setId(id);
            endereco =  enderecoRepository.save(endereco);
            return new Endereco();
            
        } else {
            return null;
        }
    }

    public void delete (Long id){
        if (enderecoRepository.existsById(id)) {
            enderecoRepository.deleteById(id);
        }
    }

}
