package br.gov.ufg.dto;

import br.gov.ufg.entity.Pedido;
import br.gov.ufg.entity.Item;
import br.gov.ufg.api.Main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoDTO {

    private static final String CAMINHO_ARQUIVO = "database/pedidos.txt";
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static List<Pedido> lerPedidosDoArquivo() throws IOException, URISyntaxException {

        // Tentar obter o caminho do arquivo como um recurso
        java.net.URL resource = Main.class.getClassLoader().getResource(CAMINHO_ARQUIVO);

        // Converter URL para URI e obter o caminho absoluto
        java.nio.file.Path caminhoArquivoAbsoluto = Paths.get(resource.toURI());

        if (resource != null) {

            return Files.lines(caminhoArquivoAbsoluto)
                    .map(line -> {
                        String[] dados = line.split(",");
                        try {
                            Integer idPedido = Integer.parseInt(dados[0]);
                            Date dataPedido = sdf.parse(dados[1]);
                            String status = dados[2];
                            List<Item> itens = new ArrayList<>();
                            for (int i = 3; i < dados.length; i += 3) {
                                Integer idItem = Integer.parseInt(dados[i]);
                                int quantidade = Integer.parseInt(dados[i + 1]);
                                BigDecimal precoUnitario = new BigDecimal(dados[i + 2]);
                                itens.add(new Item(idItem, quantidade, precoUnitario));
                            }
                            Pedido pedido = new Pedido(idPedido, dataPedido, status);
                            pedido.setItens(itens);
                            return pedido;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return null;
                        }
                    })
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public static void salvarPedidosNoArquivo(List<Pedido> pedidos) throws IOException, URISyntaxException {
        // Tentar obter o caminho do arquivo como um recurso
        java.net.URL resource = Main.class.getClassLoader().getResource(CAMINHO_ARQUIVO);

        // Converter URL para URI e obter o caminho absoluto
        java.nio.file.Path caminhoArquivoAbsoluto = Paths.get(resource.toURI());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivoAbsoluto.toFile()))) {
            for (Pedido pedido : pedidos) {
                writer.write(pedidoToCSV(pedido));
                writer.newLine();
            }
        }
    }

    private static String pedidoToCSV(Pedido pedido) {
        StringBuilder sb = new StringBuilder();
        sb.append(pedido.getIdPedido()).append(",");
        sb.append(sdf.format(pedido.getDataPedido())).append(",");
        sb.append(pedido.getStatus());
        for (Item item : pedido.getItens()) {
            sb.append(",").append(item.getIdItem());
            sb.append(",").append(item.getQuantidade());
            sb.append(",").append(item.getPrecoUnitario());
        }
        return sb.toString();
    }
}
