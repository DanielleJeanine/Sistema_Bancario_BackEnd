package com.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.DTOs.ClienteDTO;
import com.banco.DTOs.FuncionarioDTO;
import com.banco.entities.Cliente;
import com.banco.entities.Funcionario;
import com.banco.service.FuncionarioService;
//tudo funcionando nessa merda 
@RestController
@RequestMapping("funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;


    @GetMapping("/allfuncionarios")
    public ResponseEntity< List<FuncionarioDTO>> getAllFuncionarios(){
        List<FuncionarioDTO> funcionarios= funcionarioService.getAllFuncionarios();
        if(funcionarios == null ) return new ResponseEntity<>(funcionarios,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(funcionarios,HttpStatus.OK);
        
    } 
    @GetMapping("/allclientes")
    public ResponseEntity< List<ClienteDTO>> getAllClientes(){
        List<ClienteDTO> clientes= funcionarioService.getAllClientes();
        if(clientes == null) return new ResponseEntity<> (clientes, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(clientes,HttpStatus.OK);
    }

    @GetMapping("/getfuncionario/{id}")
    public ResponseEntity<FuncionarioDTO> getFuncionarioById(@PathVariable Long id){
        FuncionarioDTO funcionario = funcionarioService.getFuncionarioById(id);
        if(funcionario == null) return new ResponseEntity<>(funcionario , HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(funcionario,HttpStatus.OK);

    }

    @GetMapping("/getcliente/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable Long id){
        ClienteDTO cliente = funcionarioService.getClienteById(id);

        if(cliente == null) return new ResponseEntity<>(cliente , HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(cliente,HttpStatus.OK);
    }

    @PostMapping("/cadastro/funcionario")
    public ResponseEntity<FuncionarioDTO> saveFuncionario(@RequestBody Funcionario funcionario){
        FuncionarioDTO saveFuncionario = funcionarioService.saveFuncionario(funcionario);
        if (saveFuncionario == null) return new ResponseEntity<>(saveFuncionario, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(saveFuncionario, HttpStatus.OK);
    }

    @PostMapping("/cadastro/cliente/{id}")
    public ResponseEntity<ClienteDTO> saveCliente(@RequestBody Cliente cliente){
        ClienteDTO saveCliente = funcionarioService.saveCliente(cliente);
        if(saveCliente == null) return new ResponseEntity<>(saveCliente , HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(saveCliente,HttpStatus.OK);
    }

    @PutMapping("/update/funcionario")
    public ResponseEntity<FuncionarioDTO> updateFuncionario(@RequestBody Funcionario funcionario){
        FuncionarioDTO funcionarioAtualizado = funcionarioService.updateFuncionario(funcionario);
        if(funcionarioAtualizado == null) return new ResponseEntity<>(funcionarioAtualizado , HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(funcionarioAtualizado,HttpStatus.OK);

    }

    @PutMapping("/update/cliente")
    public ResponseEntity<ClienteDTO> updateCliente(@RequestBody Cliente cliente){
        ClienteDTO clienteAtualizado = funcionarioService.updateCliente(cliente);
        if(clienteAtualizado == null) return new ResponseEntity<>(clienteAtualizado , HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(clienteAtualizado,HttpStatus.OK);
    }

    @PutMapping("/delete/funcionario/{id}")
    public ResponseEntity<Funcionario> deleteFuncionario(@PathVariable Long id){
        Funcionario funcionario = funcionarioService.deleteFuncionario(id);
        if(funcionario == null) return new ResponseEntity<>(funcionario , HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(funcionario,HttpStatus.OK);

    }

    @PutMapping("/delete/cliente/{id}")
    public ResponseEntity<Cliente> deleteCliente(@PathVariable Long id){
        Cliente cliente = funcionarioService.deleteCliente(id);
        if(cliente == null) return new ResponseEntity<>(cliente , HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(cliente,HttpStatus.OK);
    }


}
