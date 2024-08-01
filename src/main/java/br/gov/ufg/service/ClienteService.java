package br.gov.ufg.service;

import br.gov.ufg.dto.ClienteDTO;
import br.gov.ufg.entity.Cliente;
import br.gov.ufg.entity.ClientePessoaFisica;
import br.gov.ufg.entity.ClientePessoaJuridica;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();

    public Cliente createCliente(ClienteDTO clienteDTO) {
        Cliente cliente;
        if (clienteDTO.getTipo().equals("PessoaFisica")) {
            cliente = new ClientePessoaFisica();
            ((ClientePessoaFisica) cliente).setCpf(clienteDTO.getCpf());
            ((ClientePessoaFisica) cliente).setRg(clienteDTO.getRg());
            ((ClientePessoaFisica) cliente).setDataNascimento(clienteDTO.getDataNascimento());
        } else {
            cliente = new ClientePessoaJuridica();
            ((ClientePessoaJuridica) cliente).setCnpj(clienteDTO.getCnpj());
            ((ClientePessoaJuridica) cliente).setRazaoSocial(clienteDTO.getRazaoSocial());
            ((ClientePessoaJuridica) cliente).setInscricaoEstadual(clienteDTO.getInscricaoEstadual());
        }
        cliente.setIdCliente(clienteDTO.getIdCliente());
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setEndereco(clienteDTO.getEndereco());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setUserName(clienteDTO.getUserName());
        cliente.setPassword(clienteDTO.getPassword());
        clientes.add(cliente);
        return cliente;
    }

    public Cliente updateCliente(int id, ClienteDTO clienteDTO) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente() == id) {
                cliente.setNome(clienteDTO.getNome());
                cliente.setEmail(clienteDTO.getEmail());
                cliente.setEndereco(clienteDTO.getEndereco());
                cliente.setTelefone(clienteDTO.getTelefone());
                cliente.setUserName(clienteDTO.getUserName());
                cliente.setPassword(clienteDTO.getPassword());
                if (cliente instanceof ClientePessoaFisica) {
                    ((ClientePessoaFisica) cliente).setCpf(clienteDTO.getCpf());
                    ((ClientePessoaFisica) cliente).setRg(clienteDTO.getRg());
                    ((ClientePessoaFisica) cliente).setDataNascimento(clienteDTO.getDataNascimento());
                } else {
                    ((ClientePessoaJuridica) cliente).setCnpj(clienteDTO.getCnpj());
                    ((ClientePessoaJuridica) cliente).setRazaoSocial(clienteDTO.getRazaoSocial());
                    ((ClientePessoaJuridica) cliente).setInscricaoEstadual(clienteDTO.getInscricaoEstadual());
                }
                return cliente;
            }
        }
        return null; // ou lançar uma exceção
    }

    public Cliente getClienteById(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente() == id) {
                return cliente;
            }
        }
        return null; // ou lançar uma exceção
    }

    public List<Cliente> getAllClientes() {
        return clientes;
    }

    public boolean deleteCliente(int id) {
        return clientes.removeIf(cliente -> cliente.getIdCliente() == id);
    }
}