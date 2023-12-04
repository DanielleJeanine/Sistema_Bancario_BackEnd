package com.banco.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.DTOs.ClienteDTO;
import com.banco.DTOs.FuncionarioDTO;
import com.banco.entities.Cliente;
import com.banco.entities.Funcionario;
import com.banco.repository.ClienteRepository;
import com.banco.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    
    private Funcionario funcionarioAP = new Funcionario();

    public  List<FuncionarioDTO> getAllFuncionarios(){
        List<Funcionario> listFuncionarios = funcionarioRepository.findAll();
        List<FuncionarioDTO> funcionarios = new ArrayList<>();
        if (listFuncionarios != null) {
            for (int i = 0; i < listFuncionarios.size(); i++) {
                FuncionarioDTO funcionarioDTO = new FuncionarioDTO(listFuncionarios.get(i).getNome(),
                 listFuncionarios.get(i).getCpf(), listFuncionarios.get(i).getTelefone(), listFuncionarios.get(i).getEmail());
                 funcionarios.add(funcionarioDTO);
            }
            
        }
        return funcionarios;
    }

    public List<ClienteDTO> getAllClientes(){
        List<Cliente> listaClientes = clienteRepository.findAll();
        List<ClienteDTO> clientes = new ArrayList<>();
        if (listaClientes != null) {
            for (int i = 0; i < listaClientes.size(); i++) {
                ClienteDTO clienteDTO = new ClienteDTO(listaClientes.get(i).getNome(),
                 listaClientes.get(i).getCpf(),listaClientes.get(i).getTelefone(),
                  listaClientes.get(i).getEmail(),listaClientes.get(i).getDataDeNascimento());
                   clientes.add(clienteDTO);
            }
            
        }
        return clientes;
    }

    public FuncionarioDTO getFuncionarioById(Long id){
        Funcionario funcionario = funcionarioRepository.findById(id).orElse(null);
        FuncionarioDTO funcionarioDTO =funcionarioAP.funcionarioDTO(funcionario);
        return funcionarioDTO;
    }

    public ClienteDTO getClienteById(Long id){
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        ClienteDTO clienteDTO = funcionarioAP.clienteDTO(cliente);
        return clienteDTO;
    }

    public FuncionarioDTO saveFuncionario(Funcionario funcionario){
        Funcionario funcionarioNovo = funcionarioRepository.save(funcionario);
        FuncionarioDTO funcionarioDTO =funcionarioAP.funcionarioDTO(funcionarioNovo);
        return funcionarioDTO;
    }

    public ClienteDTO saveCliente(Cliente cliente){
        Cliente clienteNovo = clienteRepository.save(cliente);
        ClienteDTO clienteDTO = funcionarioAP.clienteDTO(clienteNovo);
        return clienteDTO;
    }

    public FuncionarioDTO updateFuncionario(Funcionario funcionario){
        try {
            BeanUtils.copyProperties(this, funcionario);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Funcionario saveFuncionario = funcionarioRepository.save(funcionario);
        FuncionarioDTO funcionarioDTO =funcionarioAP.funcionarioDTO(saveFuncionario);
        return funcionarioDTO;
    }
    public ClienteDTO updateCliente (Cliente cliente ){
        try {
            BeanUtils.copyProperties(this, cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Cliente saveCliente = clienteRepository.save(cliente);
        ClienteDTO clienteDTO = funcionarioAP.clienteDTO(saveCliente);
        return clienteDTO;
    }

    public Funcionario deleteFuncionario(Long id ){
        Funcionario funcionario = funcionarioRepository.findById(id).orElse(null);
        funcionario.setAtivo(false);
        return funcionario;
    }

    public Cliente deleteCliente(Long id ){
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        cliente.setAtivo(false);
        return cliente;

    }
}
