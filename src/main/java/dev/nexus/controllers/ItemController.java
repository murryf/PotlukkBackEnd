package dev.nexus.controllers;

import dev.nexus.entities.Item;
import dev.nexus.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Component // identifies classes for Spring
@Controller // identifies Controller classes for Spring
@CrossOrigin("*") // tells Spring to enable CORS
public class ItemController{
    /* Declare Service Object */
    @Autowired // lets Spring resolve & inject bean dependencies
    public ItemService itemService;

    // CRUD:

    /* CREATE:POST item */
    @PostMapping("/items") // RequestMethod.POST shortcut
    @ResponseBody
    public Item registerNewItem(@RequestBody Item item){
        return this.itemService.registerItem(item);
    }

    /* READ:GET all items */
    @GetMapping("/items") // RequestMethod.GET shortcut
    @ResponseBody
    public List<Item> retrieveAllItems(){
        List<Item> items = this.itemService.getAllItems();
        return items;
    }

    /* READ:GET item by id */
    @GetMapping("/items/{id}")
    @ResponseBody
    public Item getItem(@PathVariable Integer id){
        Item item = this.itemService.getItemById(id);
        return item;
    }

    /* UPDATE:PUT item */
    // n/a

    /* DELETE:DELETE item */
    @DeleteMapping("/items/{id}") // RequestMethod.DELETE shortcut
    @ResponseBody
    public boolean deleteItem(@PathVariable Integer id){
        this.itemService.deleteItem(id);
        return true;
    }
}
