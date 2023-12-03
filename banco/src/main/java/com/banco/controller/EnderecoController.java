package com.banco.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.banco.entities.Endereco;
import com.banco.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Endereco>> find(@PathVariable Long id) {
        if (enderecoService.find(id) == null) {
            return ResponseEntity.notFound().build();

        } else {
            return ResponseEntity.ok(enderecoService.find(id));
        }

    }

    @GetMapping
    public ResponseEntity<List<Endereco>> listAll() {
        return ResponseEntity.ok(enderecoService.listAll());
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco add(@RequestBody Endereco endereco) {
        return enderecoService.add(endereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> update(@PathVariable Long id, @RequestBody Endereco endereco) {
        if (enderecoService.update(id, endereco) == null) {
            return ResponseEntity.notFound().build();

        } else {
            return ResponseEntity.ok(enderecoService.update(id, endereco));
        }
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id){
        enderecoService.delete(id);
    }

}
