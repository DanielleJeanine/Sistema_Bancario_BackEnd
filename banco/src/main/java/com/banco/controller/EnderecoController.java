package com.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banco.DTOs.EnderecoDTO;
import com.banco.entities.Endereco;
import com.banco.service.EnderecoService;

@RestController
@RequestMapping("endereco")
@CrossOrigin(value = "*")
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

    @GetMapping("/cliente/{id}")
    public ResponseEntity<EnderecoDTO> getEnderecoClienteById(@PathVariable Long id) {
        EnderecoDTO endereco = enderecoService.getEnderecoClienteById(id);
        if (endereco == null)
            return new ResponseEntity<>(endereco, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(endereco, HttpStatus.OK);

    }
    @GetMapping("/funcionario/{id}")
    public ResponseEntity<EnderecoDTO> getEnderecoFuncioanrioById(@PathVariable Long id) {
        EnderecoDTO endereco = enderecoService.getEnderecoFuncionarioById(id);
        if (endereco == null)
            return new ResponseEntity<>(endereco, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(endereco, HttpStatus.OK);

    }

//    @PostMapping("/cadastro/cliente/{id}")
//    public ResponseEntity<EnderecoDTO> saveEnderecoCliente(@RequestBody Endereco endereco, @PathVariable Long id) {
//        EnderecoDTO saveEndereco = enderecoService.saveEnderecoCliente(endereco, id);
//        if (saveEndereco == null)
//            return new ResponseEntity<>(saveEndereco, HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(saveEndereco, HttpStatus.OK);
//    }

    @PostMapping("/cadastro/funcionario/{id}")
    public ResponseEntity<Endereco> saveEnderecoFuncionario(@RequestBody Endereco endereco) {
        Endereco saveEndereco = enderecoService.saveEnderecoFuncionario(endereco);
        if (saveEndereco == null)
            return new ResponseEntity<>(saveEndereco, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(saveEndereco, HttpStatus.OK);
    }

    @PutMapping("/update/cliente/{id}")
    public ResponseEntity<EnderecoDTO> updateEnderecoCliente(@RequestBody Endereco endereco, @PathVariable Long id) {
        EnderecoDTO enderecoAtualizado = enderecoService.updateEnderecoCliente(endereco, id);
        if (enderecoAtualizado == null)
            return new ResponseEntity<>(enderecoAtualizado, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(enderecoAtualizado, HttpStatus.OK);

    }

    @PutMapping("/update/funcionario/{id}")
    public ResponseEntity<EnderecoDTO> updateEnderecoFuncionario(@RequestBody Endereco endereco,
            @PathVariable Long id) {
        EnderecoDTO enderecoAtualizado = enderecoService.updateEnderecoFuncionario(endereco, id);
        if (enderecoAtualizado == null)
            return new ResponseEntity<>(enderecoAtualizado, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(enderecoAtualizado, HttpStatus.OK);

    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<EnderecoDTO> deleteEndereco(@PathVariable Long id) {
        EnderecoDTO endereco = enderecoService.deleteEndereco(id);
        if (endereco == null)
            return new ResponseEntity<>(endereco, HttpStatus.OK);
        return new ResponseEntity<>(endereco, HttpStatus.BAD_REQUEST);

    }

}
