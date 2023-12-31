package com.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.banco.DTOs.ContaDTO;
import com.banco.DTOs.ExtratoDTO;
import com.banco.entities.conta.Conta;
import com.banco.service.ContaService;

@RestController
@RequestMapping("conta")
@CrossOrigin(value = "*")
public class ContaController {
    @Autowired
    private ContaService contaService;
    
    @GetMapping("/all/{id}")
    public ResponseEntity<List<ContaDTO>> getAllContas(@PathVariable Long id){
        List<ContaDTO> contas = contaService.getAllcontas(id);
        return new ResponseEntity<>(contas,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ContaDTO> getContaById(@PathVariable Long id){
        ContaDTO conta = contaService.getContaById(id);
        return new ResponseEntity<>(conta,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<ContaDTO> updateConta(@RequestBody Conta conta ){
        ContaDTO contaAtualizada = contaService.updateConta(conta);
        return new ResponseEntity<>(contaAtualizada, HttpStatus.OK);
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<ContaDTO> deleteLogical(@PathVariable Long id){
        ContaDTO conta = contaService.deleteLogical(id);
        return new ResponseEntity<>(conta, HttpStatus.OK);
    }

    @PostMapping("/cadastrar/{id}")
    public ResponseEntity<ContaDTO> saveConta(@RequestBody Conta conta,@PathVariable Long id){
        // Cliente cliente =contaService.getCliente(id);
        // Conta contaNova = new Conta();
        // contaNova.setTitularDaConta(cliente);
        // contaNova.setNumeroDaConta(conta.numeroDaConta());
        // contaNova.setTipoDeConta(conta.tipoDaConta());
        // contaNova.setSaldo(conta.saldo());
        // contaNova.setStatusAtivo(true);
        ContaDTO contaNova = contaService.saveConta(conta, id);
        // if(contaNova == null) return new ResponseEntity<>(contaNova, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(contaNova, HttpStatus.OK);
        
    }
    @GetMapping("/extrato/{id}")
    public ResponseEntity<ExtratoDTO> getExtrato(@PathVariable Long id){
        ExtratoDTO extrato = contaService.getExtrato(id);
        if(extrato == null) return new ResponseEntity<>(extrato, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(extrato, HttpStatus.OK);
    }
}
