package com.banco.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.entities.Cliente;
import com.banco.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Optional<Cliente> find (Long id){
        return clienteRepository.findById(id);

    }
}
