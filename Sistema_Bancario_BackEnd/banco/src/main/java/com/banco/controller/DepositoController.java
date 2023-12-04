package com.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.banco.DTOs.DepositoDTO;
import com.banco.entities.conta.Deposito;
import com.banco.service.DepositoService;

@RestController
@RequestMapping("deposito")
public class DepositoController {
    @Autowired
    private DepositoService depositoService;
    
    @GetMapping("/{id}")
    public ResponseEntity<List<DepositoDTO>> getAllDepositos(@PathVariable Long id){
        List<DepositoDTO> depositos = depositoService.getDepositos(id);
        if(depositos == null) return new ResponseEntity<>(depositos,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(depositos,HttpStatus.OK);
    }
    @PostMapping("/realizar/{id}")
    public ResponseEntity<DepositoDTO> postDeposito(@PathVariable Long id ,@RequestBody Deposito deposito){
        DepositoDTO depositoDTO = depositoService.postDeposito(deposito, id);
        if(depositoDTO == null) return new ResponseEntity<>(depositoDTO,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(depositoDTO, HttpStatus.OK);
    }

}