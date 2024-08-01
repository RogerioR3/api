package br.gov.ufg.service;

import br.gov.ufg.dto.ProdutoDTO;
import br.gov.ufg.entity.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoService {
    private List<Produto> produtos = new ArrayList<>();

    public Produto createProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setIdProduto(produtoDTO.getIdProduto());
        produto.setNome(produtoDTO.getNome());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setPreco(produtoDTO.getPreco());
        produto.setEstoque(produtoDTO.getEstoque());
        produtos.add(produto);
        return produto;
    }

    public Produto updateProduto(int id, ProdutoDTO produtoDTO) {
        for (Produto produto : produtos) {
            if (produto.getIdProduto() == id) {
                produto.setNome(produtoDTO.getNome());
                produto.setDescricao(produtoDTO.getDescricao());
                produto.setPreco(produtoDTO.getPreco());
                produto.setEstoque(produtoDTO.getEstoque());
                return produto;
            }
        }
        return null; // ou lançar uma exceção
    }

    public Produto getProdutoById(int id) {
        for (Produto produto : produtos) {
            if (produto.getIdProduto() == id) {
                return produto;
            }
        }
        return null; // ou lançar uma exceção
    }

    public List<Produto> getAllProdutos() {
        return produtos;
    }

    public boolean deleteProduto(int id) {
        return produtos.removeIf(produto -> produto.getIdProduto() == id);
    }
}