package com.banco.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.DTOs.ClienteDTO;
import com.banco.entities.Cliente;
import com.banco.entities.conta.Conta;
import com.banco.entities.conta.Deposito;
import com.banco.entities.conta.Saque;
import com.banco.repository.ClienteRepository;
//camada do cliente será somente para ver o seu cadastro, mudar a sua senha ou login, mudar seu endereco.
//camada do funcionario add cliente/Funcionario, cria conta para funcionario, muda senha ou login do funcionario, 
//se der para fazer colocar uma forma de o gerente aprovar transferencias a cima de 2000 reais.
@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private ContaService contaService;


    public ClienteDTO getInfoCliente(Long id){
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        ClienteDTO clienteDTO = cliente.clienteDTO(cliente);
        return clienteDTO;

    }

    public Cliente saveCliente(Cliente cliente){
        cliente.setEnderecoCliente(enderecoService.saveEndereco(cliente.getEnderecoCliente()));
        cliente.setConta(contaService.criarConta(cliente.getConta()));
        Cliente clienteNovo = clienteRepository.save(cliente);
        return clienteNovo;
    }
    public Cliente updateCliente(Cliente clienteAtualizado, Long id){
       if(clienteAtualizado == null ) return null;

       try {
        BeanUtils.copyProperties(this, clienteAtualizado);
    } catch (Exception e) {
        e.printStackTrace();
    }
         clienteRepository.save(clienteAtualizado);
        return clienteAtualizado;
    }
    public Cliente deleteLogical(Long id){
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        cliente.setAtivo(false);
        return cliente;

    }
//    public List<Conta>getAllContas(Long id ){
//        Cliente cliente = clienteRepository.findById(id).orElse(null);
//        List<Conta> contas= cliente.getConta();
//        return contas;
//    }

//    public List<Saque> getAllSaques(Long id, String numero_Conta){
////        Cliente cliente = clienteRepository.findById(id).orElse(null);
////        for(int i = 0 ;i<cliente.getContas().size();i++){
////            if( numero_Conta.equals(cliente.getContas().get(i).getNumeroDaConta())){
////                return cliente.getContas().get(i).getSaques();
////            }
////        }
////        return null;
////
////    }
////    public List<Deposito> getAllDepositos(Long id, String numero_Conta){
////        Cliente cliente = clienteRepository.findById(id).orElse(null);
////        for(int i = 0 ;i<cliente.getContas().size();i++){
////            if( numero_Conta.equals(cliente.getContas().get(i).getNumeroDaConta())){
////                return cliente.getContas().get(i).getDepositos();
////            }
////        }
////        return null;

//    }
    // public ExtratoDTO getAllTransferencias(Long id, String numero_Conta){
    //     Cliente cliente = clienteRepository.findById(id).orElse(null);
    //     for(int i = 0 ;i<cliente.getContas().size();i++){
    //         if( numero_Conta.equals(cliente.getContas().get(i).getNumeroDaConta())){
    //             return ExtratoDTO(cliente.getContas().get(i).getDepositos(),
    //             cliente.getContas().get(i).getSaques(),
    //             cliente.getContas().get(i).getTransfereciasDestino());
    //         }
    //     }
    //     return null;

    // }
        


}
