package com.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.banco.DTOs.TransferenciaDTO;
import com.banco.entities.conta.Transferencia;
import com.banco.service.TransferenciaService;

@RestController
@RequestMapping("transferencia")
@CrossOrigin(value = "*")
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferenciaService;
    
    @GetMapping("/{id}")
    public ResponseEntity<List<TransferenciaDTO>> getAllTransferencias(@PathVariable Long id){
        List<TransferenciaDTO> transferencia = transferenciaService.getTransferencias(id);
        if(transferencia == null) return new ResponseEntity<>(transferencia,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(transferencia,HttpStatus.OK);
    }
    @PostMapping("/{idOrigem}")
    public ResponseEntity<TransferenciaDTO> postTransferencia(
            @PathVariable Long idOrigem,
            @RequestBody Transferencia transferencia
    ) {
        TransferenciaDTO transferenciaDTO = transferenciaService.postTransferencia(idOrigem, transferencia);
        
        if (transferenciaDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>(transferenciaDTO, HttpStatus.OK);
    }
}



