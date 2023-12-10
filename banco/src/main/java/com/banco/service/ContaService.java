package com.banco.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.banco.DTOs.ContaDTO;
import com.banco.DTOs.DepositoDTO;
import com.banco.DTOs.ExtratoDTO;
import com.banco.DTOs.SaqueDTO;
import com.banco.DTOs.TransferenciaDTO;
import com.banco.entities.Cliente;
import com.banco.entities.conta.Conta;
import com.banco.entities.conta.Deposito;
import com.banco.entities.conta.Saque;
import com.banco.entities.conta.Transferencia;
import com.banco.repository.ClienteRepository;
import com.banco.repository.ContaRepository;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;
    @Autowired 
    private ClienteRepository clienteRepository;

    public Cliente getCliente(Long id){
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        return cliente;

    }
    public List<ContaDTO> getAllcontas(Long id){
        Cliente cliente = getCliente(id);
        List<Conta> contas = cliente.getContas();
        List<ContaDTO> contasDTO = new ArrayList<>();
        if(contas != null){
            for (int i = 0; i < contas.size(); i++) {
                ContaDTO contaDTO = new ContaDTO(contas.get(i).getNumeroDaConta(), contas.get(i).getTipoDeConta(),
                 contas.get(i).getId(), contas.get(i).getTitularDaConta().getNome(), contas.get(i).getSaldo());
                contasDTO.add(contaDTO);
            }
        }
        return contasDTO;
        
    }
    public ContaDTO getContaById(Long id){
        Conta conta = contaRepository.findById(id).orElse(null);
        ContaDTO contaDTO = conta.contaDTO(conta);
        return contaDTO;
    }
    public ContaDTO updateConta(Conta conta){
        try {
            // Copia as propriedades do novoCliente para o cliente existente
            BeanUtils.copyProperties(this, conta);
        } catch (Exception e) {
            // Trate qualquer exceção que possa ocorrer durante a cópia das propriedades
            e.printStackTrace();
        }
        contaRepository.save(conta);
        ContaDTO contaDTO = conta.contaDTO(conta);
        return contaDTO;
    }

    public ContaDTO deleteLogical(Long id){
        Conta conta = contaRepository.findById(id).orElse(null);
        ContaDTO contaDTO = conta.contaDTO(conta);
        conta.setStatusAtivo(false);
        return contaDTO;
    }



    public ContaDTO saveConta(Conta conta,Long id){
        Cliente cliente = getCliente(id);
        Conta contaNova = new Conta();
        contaNova.setNumeroDaConta(conta.getNumeroDaConta());
        contaNova.setTipoDeConta(conta.getTipoDeConta());
        contaNova.setSaldo(conta.getSaldo());
        contaNova.setStatusAtivo(true);
        contaNova.setTitularDaConta(cliente);
        
        contaRepository.save(contaNova);
        ContaDTO contaRetorno = conta.contaDTO(contaNova);
        return contaRetorno;
    }
    public ExtratoDTO getExtrato(Long id) {
        Conta conta = contaRepository.findById(id).orElse(null);
        List<SaqueDTO> saquesDTO = new ArrayList<>();
        List<DepositoDTO> depositosDTO = new ArrayList<>();
        List<TransferenciaDTO> transferenciasDTO = new ArrayList<>();
        
    
        if (conta != null) {
            for (int i = 0; i < conta.getSaques().size(); i++) {
                SaqueDTO saqueDTO = new SaqueDTO(conta.getSaques().get(i).getData(),
                conta.getSaques().get(i).getValor(), true);
                saquesDTO.add(saqueDTO);
                
            }
        }
        if (conta != null) {
            for (int i = 0; i < conta.getDepositos().size(); i++) {
                DepositoDTO depositoDTO = new DepositoDTO(conta.getDepositos().get(i).getData(),
                conta.getDepositos().get(i).getValor(), true);
                depositosDTO.add(depositoDTO);
                
            }
        }
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
        
        ExtratoDTO extratoDTO = new ExtratoDTO(saquesDTO,depositosDTO, transferenciasDTO);
        return extratoDTO;
        
    }
    
}
