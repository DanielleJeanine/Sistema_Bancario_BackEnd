package com.banco.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banco.DTOs.ClienteDTO;
import com.banco.entities.Cliente;
import com.banco.service.ClienteService;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(value = "*")
public class ClienteController {
    //tudo funcionando
    @Autowired
    private ClienteService clienteService;


    @GetMapping("/perfil/{id}")
    public ResponseEntity <ClienteDTO> getInfoCliente(@PathVariable Long id){
        ClienteDTO cliente = clienteService.getInfoCliente(id);
        if(cliente == null) return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(cliente,HttpStatus.OK);
        
        
    }
    @PostMapping("/cadastro")
    public ResponseEntity <Cliente> saveCliente(@RequestBody Cliente cliente ){
        Cliente clienteNovo = clienteService.saveCliente(cliente);
        if(clienteNovo ==  null) return new ResponseEntity<>(clienteNovo, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(clienteNovo,HttpStatus.OK);

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente,@PathVariable Long id){
        Cliente clienteAtualizado = clienteService.updateCliente(cliente,id);
        if(clienteAtualizado ==  null) return new ResponseEntity<>(clienteAtualizado, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(clienteAtualizado,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Cliente> deleteLogicalCliente(@PathVariable Long id){
        Cliente cliente = clienteService.deleteLogical(id);
        if(cliente ==  null) return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(cliente,HttpStatus.OK);
       

    }
    // @GetMapping("/extrato/{id}")
    // public ResponseEntity <ExtratoDTO> extrato(@PathVariable Long id, @RequestBody String numero_conta){
    //     ExtratoDTO extrato = clienteService.getAllTransferencias(id, numero_conta);
    //     return new ResponseEntity<>(extrato, HttpStatus.OK);
    // }
}
