package br.gov.ufg.controller;

import br.gov.ufg.dto.ClienteDTO;
import br.gov.ufg.entity.Cliente;
import br.gov.ufg.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public Cliente createCliente(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.createCliente(clienteDTO);
    }

    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable int id, @RequestBody ClienteDTO clienteDTO) {
        return clienteService.updateCliente(id, clienteDTO);
    }

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable int id) {
        return clienteService.getClienteById(id);
    }

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @DeleteMapping("/{id}")
    public boolean deleteCliente(@PathVariable int id) {
        return clienteService.deleteCliente(id);
    }
}