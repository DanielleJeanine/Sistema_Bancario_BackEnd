package com.banco.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.banco.DTOs.ContaDTO;
import com.banco.DTOs.SaqueDTO;
import com.banco.entities.Cliente;
import com.banco.entities.conta.Conta;
import com.banco.entities.conta.Saque;
import com.banco.repository.ClienteRepository;
import com.banco.repository.ContaRepository;
import com.banco.repository.SaqueRepository;

@Service
public class SaqueService {
    //metodos: ver todos saque,realizar saques.
    @Autowired
    public SaqueRepository saqueRepository;
    @Autowired
    public ContaRepository contaRepository;

    //valor, data,status e conta

    public SaqueDTO postSaque(Saque saque,Long id){
        Conta conta = contaRepository.findById(id).orElse(null);
        Saque saqueNovo = new Saque();
        saqueNovo.setContaOrigem(conta);
        saqueNovo.setValor(saque.getValor());
        saqueNovo.setConcluidoComSucesso(true);
        saqueNovo.setData(saque.getData());
        if(saqueNovo.getValor()!= null && conta.getSaldo() > saqueNovo.getValor()){

            saqueNovo.setContaOrigem(conta);
            conta.setSaldo(conta.getSaldo()-saqueNovo.getValor());
            contaRepository.save(conta);
            saqueRepository.save(saqueNovo);
            SaqueDTO saqueDTO = new SaqueDTO(saqueNovo.getData(), saqueNovo.getValor(), true);
            return saqueDTO;
        }
        else{
            return null;
        }
    }
    public List<SaqueDTO> getSaques(Long id) {
        Conta conta = contaRepository.findById(id).orElse(null);
        List<SaqueDTO> saquesDTO = new ArrayList<>();
    
        if (conta.getSaques() != null) {
            for (int i = 0; i < conta.getSaques().size(); i++) {
                SaqueDTO saqueDTO = new SaqueDTO(conta.getSaques().get(i).getData(),
                conta.getSaques().get(i).getValor(), true);
                saquesDTO.add(saqueDTO);
                
            }
        }
    
        return saquesDTO;
    }



}
