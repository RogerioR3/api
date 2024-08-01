package br.gov.ufg.controller;

import br.gov.ufg.dto.ItemDTO;
import br.gov.ufg.entity.Item;
import br.gov.ufg.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public Item createItem(@RequestBody ItemDTO itemDTO) {
        return itemService.createItem(itemDTO);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable int id, @RequestBody ItemDTO itemDTO) {
        return itemService.updateItem(id, itemDTO);
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable int id) {
        return itemService.getItemById(id);
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @DeleteMapping("/{id}")
    public boolean deleteItem(@PathVariable int id) {
        return itemService.deleteItem(id);
    }
}