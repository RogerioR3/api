package br.gov.ufg;

import br.gov.ufg.controller.ClienteController;
import br.gov.ufg.controller.ItemController;
import br.gov.ufg.controller.PedidoController;
import br.gov.ufg.controller.ProdutoController;
import br.gov.ufg.dto.ClienteDTO;
import br.gov.ufg.dto.ItemDTO;
import br.gov.ufg.dto.PedidoDTO;
import br.gov.ufg.dto.ProdutoDTO;
import br.gov.ufg.memento.Caretaker;
import br.gov.ufg.memento.Originator;
import br.gov.ufg.service.ClienteService;
import br.gov.ufg.service.ItemService;
import br.gov.ufg.service.PedidoService;
import br.gov.ufg.service.ProdutoService;

public class Main {
    public static void main(String[] args) {
        // Inicializando os serviços
        ClienteService clienteService = new ClienteService();
        ItemService itemService = new ItemService();
        PedidoService pedidoService = new PedidoService();
        ProdutoService produtoService = new ProdutoService();

        // Inicializando os controladores com os serviços
        ClienteController clienteController = new ClienteController(clienteService);
        ItemController itemController = new ItemController(itemService);
        PedidoController pedidoController = new PedidoController(pedidoService);
        ProdutoController produtoController = new ProdutoController(produtoService);

        // Exemplo de Cliente Pessoa Física
        ClienteDTO clienteFisico = new ClienteDTO();
        clienteFisico.setNome("João Silva");
        clienteFisico.setEmail("joao@example.com");
        clienteFisico.setEndereco("Rua A, 123");
        clienteFisico.setTelefone("123456789");
        clienteFisico.setUserName("joaosilva");
        clienteFisico.setPassword("password123");
        clienteFisico.setTipo("PessoaFisica");
        clienteFisico.setCpf("123.456.789-00");
        clienteFisico.setRg("MG-12.345.678");
        clienteFisico.setDataNascimento(new java.util.Date());
        clienteController.createCliente(clienteFisico);

        // Exemplo de Cliente Pessoa Jurídica
        ClienteDTO clienteJuridico = new ClienteDTO();
        clienteJuridico.setNome("Empresa XYZ");
        clienteJuridico.setEmail("contato@xyz.com");
        clienteJuridico.setEndereco("Avenida B, 456");
        clienteJuridico.setTelefone("987654321");
        clienteJuridico.setUserName("empresaXYZ");
        clienteJuridico.setPassword("securePass");
        clienteJuridico.setTipo("PessoaJuridica");
        clienteJuridico.setCnpj("12.345.678/0001-00");
        clienteJuridico.setRazaoSocial("Empresa XYZ LTDA");
        clienteJuridico.setInscricaoEstadual("123.456.789.012");
        clienteController.createCliente(clienteJuridico);

        // Exemplo de Produto
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setNome("Produto 1");
        produtoDTO.setDescricao("Descrição do Produto 1");
        produtoDTO.setPreco(100.0);
        produtoDTO.setEstoque(50);
        produtoController.createProduto(produtoDTO);

        // Exemplo de Item
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setQuantidade(2);
        itemDTO.setPrecoUnitario(100.0);
        itemController.createItem(itemDTO);

        // Exemplo de Pedido
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setStatus("Em processamento");
        pedidoController.createPedido(pedidoDTO);

        // Exemplo de uso do padrão Memento
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("Estado #1");
        caretaker.add(originator.saveStateToMemento());

        originator.setState("Estado #2");
        caretaker.add(originator.saveStateToMemento());

        originator.setState("Estado #3");
        System.out.println("Estado atual: " + originator.getState());

        originator.getStateFromMemento(caretaker.get(0));
        System.out.println("Primeiro estado salvo: " + originator.getState());

        originator.getStateFromMemento(caretaker.get(1));
        System.out.println("Segundo estado salvo: " + originator.getState());
    }
}
