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


import com.banco.entities.Endereco;
import com.banco.service.EnderecoService;

@RestController
@RequestMapping("endereco")
public class EnderecoController {

    ///foda-se
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/allenderecos")
    public ResponseEntity<List<Endereco>> getAllEnderecos() {
        List<Endereco> enderecos = enderecoService.getAllEnderecos();
        if (enderecos == null)
            return new ResponseEntity<>(enderecos, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(enderecos, HttpStatus.OK);

    }

    @GetMapping("/getEndereco/{id}")
    public ResponseEntity<Endereco> getEnderecoById(@PathVariable Long id) {
        Endereco endereco = enderecoService.getEnderecoById(id);
        if (endereco == null)
            return new ResponseEntity<>(endereco, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(endereco, HttpStatus.OK);

    }

    @PostMapping("/cadastro/endereco/cliente/{id}")
    public ResponseEntity<Endereco> saveEnderecoCliente(@RequestBody Endereco endereco, @PathVariable Long id) {
        Endereco saveEndereco = enderecoService.saveEnderecoCliente(endereco, id);
        if (saveEndereco == null)
            return new ResponseEntity<>(saveEndereco, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(saveEndereco, HttpStatus.OK);
    }

    @PostMapping("/cadastro/endereco/funcionario/{id}")
    public ResponseEntity<Endereco> saveEnderecoFuncionario(@RequestBody Endereco endereco, @PathVariable Long id) {
        Endereco saveEndereco = enderecoService.saveEnderecoFuncionario(endereco, id);
        if (saveEndereco == null)
            return new ResponseEntity<>(saveEndereco, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(saveEndereco, HttpStatus.OK);
    }

    @PutMapping("/update/endereco/{id}")
    public ResponseEntity<Endereco> updateEndereco(@RequestBody Endereco endereco, @PathVariable Long id) {
        Endereco enderecoAtualizado = enderecoService.updateEndereco(endereco, id);
        if (enderecoAtualizado == null)
            return new ResponseEntity<>(enderecoAtualizado, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(enderecoAtualizado, HttpStatus.OK);

    }

    @PutMapping("/delete/endereco/{id}")
    public ResponseEntity<Endereco> deleteEndereco(@PathVariable Long id) {
        Endereco endereco = enderecoService.deleteEndereco(id);
        if (endereco == null)
            return new ResponseEntity<>(endereco, HttpStatus.OK);
        return new ResponseEntity<>(endereco, HttpStatus.BAD_REQUEST);

    }

}
