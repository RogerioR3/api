package br.gov.ufg.service;

import br.gov.ufg.dto.ItemDTO;
import br.gov.ufg.entity.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemService {
    private List<Item> items = new ArrayList<>();

    public Item createItem(ItemDTO itemDTO) {
        Item item = new Item();
        item.setIdItem(itemDTO.getIdItem());
        item.setQuantidade(itemDTO.getQuantidade());
        item.setPrecoUnitario(itemDTO.getPrecoUnitario());
        items.add(item);
        return item;
    }

    public Item updateItem(int id, ItemDTO itemDTO) {
        for (Item item : items) {
            if (item.getIdItem() == id) {
                item.setQuantidade(itemDTO.getQuantidade());
                item.setPrecoUnitario(itemDTO.getPrecoUnitario());
                return item;
            }
        }
        return null; // ou lançar uma exceção
    }

    public Item getItemById(int id) {
        for (Item item : items) {
            if (item.getIdItem() == id) {
                return item;
            }
        }
        return null; // ou lançar uma exceção
    }

    public List<Item> getAllItems() {
        return items;
    }

    public boolean deleteItem(int id) {
        return items.removeIf(item -> item.getIdItem() == id);
    }
}