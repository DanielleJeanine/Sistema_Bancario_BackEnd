package com.banco.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.DTOs.ContaDTO;
import com.banco.DTOs.TransferenciaDTO;
import com.banco.entities.Cliente;
import com.banco.entities.conta.Conta;
import com.banco.entities.conta.Transferencia;
import com.banco.repository.ClienteRepository;
import com.banco.repository.ContaRepository;
import com.banco.repository.TransferenciaRepository;

@Service
public class TransferenciaService {

    @Autowired
    public TransferenciaRepository transferenciaRepository;
    @Autowired
    public ContaRepository contaRepository;

    // valor, data,status e conta

    public TransferenciaDTO postTransferencia(Transferencia transferencia, Long id) {
        Transferencia transferenciaNova = new Transferencia();
        Conta contaOrigem = contaRepository.findById(id).orElse(null);
        transferenciaNova.setContaOrigem(contaOrigem);
        transferenciaNova.setValor(transferenciaNova.getValor());
        transferenciaNova.setConcluidoComSucesso(true);
        transferenciaNova.setData(transferenciaNova.getData());
        
        
        if (transferenciaNova.getValor() != null && contaOrigem!= null ) {
            
            transferenciaNova.setContaDestino(contaOrigem);
            transferenciaRepository.save(transferenciaNova);
            TransferenciaDTO transferenciaNovaDTO = new TransferenciaDTO(transferenciaNova.getData(),
             transferenciaNova.getValor(), true, contaOrigem.getNumeroDaConta(),
             transferenciaNova.getContaDestino().getNumeroDaConta());
            return transferenciaNovaDTO;
        } else {
            return null;
        }
    }

    public List<TransferenciaDTO> getTransferencias(Long id) {
        Conta conta = contaRepository.findById(id).orElse(null);
        List<TransferenciaDTO> saquesDTO = new ArrayList<>();

        if (conta.getTransfereciasDestino() != null) {
            for (int i = 0; i < conta.getTransfereciasDestino().size(); i++) {
                TransferenciaDTO transferenciaDTO = new TransferenciaDTO(conta.getTransfereciasDestino().get(i).getData(),
             conta.getTransfereciasDestino().get(i).getValor(), true, conta.getTransfereciasDestino().get(i).getContaOrigem().getNumeroDaConta(),
             conta.getTransfereciasDestino().get(i).getContaDestino().getNumeroDaConta());
                saquesDTO.add(transferenciaDTO);

            }
        }
        if (conta.getTransfereciasOrigem() != null) {
            for (int i = 0; i < conta.getTransfereciasOrigem().size(); i++) {
                TransferenciaDTO transferenciaDTO = new TransferenciaDTO(conta.getTransfereciasOrigem().get(i).getData(),
             conta.getTransfereciasOrigem().get(i).getValor(), true, conta.getTransfereciasOrigem().get(i).getContaOrigem().getNumeroDaConta(),
             conta.getTransfereciasOrigem().get(i).getContaOrigem().getNumeroDaConta());
                saquesDTO.add(transferenciaDTO);

            }
        }

        return saquesDTO;
    }

}
