package com.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.banco.DTOs.SaqueDTO;
import com.banco.entities.conta.Saque;
import com.banco.service.SaqueService;

@RestController
@RequestMapping("saque")
@CrossOrigin(value = "*")
public class SaqueController {
    @Autowired
    private SaqueService saqueService;
    
    @GetMapping("/{id}")
    public ResponseEntity<List<SaqueDTO>> getAllSaques(@PathVariable Long id){
        List<SaqueDTO> saques = saqueService.getSaques(id);
        if(saques == null) return new ResponseEntity<>(saques,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(saques,HttpStatus.OK);
    }
    @PostMapping("/saque/{id}")
    public ResponseEntity<SaqueDTO> postSaque(@PathVariable Long id ,@RequestBody Saque saque){
        SaqueDTO saqueDTO = saqueService.postSaque(saque, id);
        if(saqueDTO == null) return new ResponseEntity<>(saqueDTO,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(saqueDTO, HttpStatus.OK);
    }

    @PostMapping("/sacar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Saque sacar (@RequestBody Saque novoSaque, @PathVariable Long id){
        return saqueService.realizarSaque(novoSaque, id);
    }

}
