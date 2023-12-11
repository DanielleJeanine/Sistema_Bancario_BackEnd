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

    @Autowired
    EmailService emailService;

    // valor, data,status e conta

    public TransferenciaDTO postTransferencia(Long idOrigem, Transferencia transferencia) {
        Conta contaOrigem = contaRepository.findById(idOrigem).orElse(null);
        Conta contaDestino = contaRepository.findById(transferencia.getContaDestino().getId()).orElse(null);
        
        if (contaOrigem != null && contaDestino != null && transferencia.getValor() != null && contaOrigem.getSaldo()>transferencia.getValor() ) {
            transferencia.setContaOrigem(contaOrigem);
            transferencia.setContaDestino(contaDestino);

            contaOrigem.setSaldo(contaOrigem.getSaldo()-transferencia.getValor());
            contaDestino.setSaldo(contaDestino.getSaldo()+transferencia.getValor());
            contaRepository.save(contaOrigem);
            contaRepository.save(contaDestino);

            transferenciaRepository.save(transferencia);
            emailService.enviarEmail("danjeyfull@gmail.com","Realização de Transferência", "Foi realizado em sua conta uma transferência de R$ " + transferencia.getValor());


            TransferenciaDTO transferenciaDTO = new TransferenciaDTO(
                    transferencia.getData(),
                    transferencia.getValor(),
                    true,
                    contaOrigem.getNumeroDaConta(),
                    contaDestino.getNumeroDaConta()
            );

            return transferenciaDTO;
        } else {
            return null;
        }
    }


    public List<TransferenciaDTO> getTransferencias(Long id) {
        Conta conta = contaRepository.findById(id).orElse(null);
        List<TransferenciaDTO> transferenciasDTO = new ArrayList<>();
    
        if (conta != null) {
            if (conta.getTransfereciasDestino() != null) {
                for (Transferencia transferencia : conta.getTransfereciasDestino()) {
                    TransferenciaDTO transferenciaDTO = new TransferenciaDTO(
                            transferencia.getData(),
                            transferencia.getValor(),
                            true,
                            transferencia.getContaOrigem().getNumeroDaConta(),
                            transferencia.getContaDestino().getNumeroDaConta()
                    );
                    transferenciasDTO.add(transferenciaDTO);
                }
            }
    
            if (conta.getTransfereciasOrigem() != null) {
                for (Transferencia transferencia : conta.getTransfereciasOrigem()) {
                    TransferenciaDTO transferenciaDTO = new TransferenciaDTO(
                            transferencia.getData(),
                            transferencia.getValor(),
                            true,
                            transferencia.getContaOrigem().getNumeroDaConta(),
                            transferencia.getContaDestino().getNumeroDaConta()
                    );
                    transferenciasDTO.add(transferenciaDTO);
                }
            }
        }
    
        return transferenciasDTO;
    }

}
