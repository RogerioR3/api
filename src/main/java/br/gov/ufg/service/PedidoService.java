package br.gov.ufg.service;

import br.gov.ufg.dto.PedidoDTO;
import br.gov.ufg.entity.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoService {
    private List<Pedido> pedidos = new ArrayList<>();

    public Pedido createPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        pedido.setIdPedido(pedidoDTO.getIdPedido());
        pedido.setDataPedido(pedidoDTO.getDataPedido());
        pedido.setStatus(pedidoDTO.getStatus());
        pedidos.add(pedido);
        return pedido;
    }

    public Pedido updatePedido(int id, PedidoDTO pedidoDTO) {
        for (Pedido pedido : pedidos) {
            if (pedido.getIdPedido() == id) {
                pedido.setDataPedido(pedidoDTO.getDataPedido());
                pedido.setStatus(pedidoDTO.getStatus());
                return pedido;
            }
        }
        return null; // ou lançar uma exceção
    }

    public Pedido getPedidoById(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getIdPedido() == id) {
                return pedido;
            }
        }
        return null; // ou lançar uma exceção
    }

    public List<Pedido> getAllPedidos() {
        return pedidos;
    }

    public boolean deletePedido(int id) {
        return pedidos.removeIf(pedido -> pedido.getIdPedido() == id);
    }
}