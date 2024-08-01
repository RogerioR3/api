package br.gov.ufg.controller;

import br.gov.ufg.dto.PedidoDTO;
import br.gov.ufg.entity.Pedido;
import br.gov.ufg.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public Pedido createPedido(@RequestBody PedidoDTO pedidoDTO) {
        return pedidoService.createPedido(pedidoDTO);
    }

    @PutMapping("/{id}")
    public Pedido updatePedido(@PathVariable int id, @RequestBody PedidoDTO pedidoDTO) {
        return pedidoService.updatePedido(id, pedidoDTO);
    }

    @GetMapping("/{id}")
    public Pedido getPedidoById(@PathVariable int id) {
        return pedidoService.getPedidoById(id);
    }

    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoService.getAllPedidos();
    }

    @DeleteMapping("/{id}")
    public boolean deletePedido(@PathVariable int id) {
        return pedidoService.deletePedido(id);
    }
}