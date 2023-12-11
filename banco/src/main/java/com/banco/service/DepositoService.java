package com.banco.service;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.spec.DESKeySpec;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.banco.DTOs.ContaDTO;
import com.banco.DTOs.DepositoDTO;
import com.banco.entities.Cliente;
import com.banco.entities.conta.Conta;
import com.banco.entities.conta.Deposito;
import com.banco.entities.conta.Deposito;
import com.banco.repository.ClienteRepository;
import com.banco.repository.ContaRepository;
import com.banco.repository.DepositoRepository;

@Service
public class DepositoService {
 @Autowired
    public DepositoRepository depositoRepository;
    @Autowired
    public ContaRepository contaRepository;

    @Autowired
    EmailService emailService;

    //valor, data,status e conta

    public DepositoDTO postDeposito(Deposito deposito,Long id){
        Deposito depositoNovo = new Deposito();
        Conta conta = contaRepository.findById(id).orElse(null);
        depositoNovo.setContaDestino(conta);
        depositoNovo.setValor(deposito.getValor());
        depositoNovo.setConcluidoComSucesso(true);
        depositoNovo.setData(deposito.getData());
        if(depositoNovo.getValor()!= null){
            depositoNovo.setContaDestino(conta);
            conta.setSaldo(conta.getSaldo()+depositoNovo.getValor());

            contaRepository.save(conta);
            depositoRepository.save(depositoNovo);
            emailService.enviarEmail("danjeyfull@gmail.com","Realização de Depósito","Foi realizado em sua conta um depósito de R$ " +depositoNovo.getValor());

            DepositoDTO depositoDTO = new DepositoDTO(depositoNovo.getData(), depositoNovo.getValor(), true);
            return depositoDTO;
        }
        else{
            return null;
        }
    }
    public List<DepositoDTO> getDepositos(Long id) {
        Conta conta = contaRepository.findById(id).orElse(null);
        List<DepositoDTO> depositosDTO = new ArrayList<>();
    
        if (conta.getDepositos() != null) {
            for (int i = 0; i < conta.getSaques().size(); i++) {
                DepositoDTO depositoDTO = new DepositoDTO(conta.getDepositos().get(i).getData(),
                conta.getDepositos().get(i).getValor(), true);
                depositosDTO.add(depositoDTO);
                
            }
        }
    
        return depositosDTO;
    }



}
