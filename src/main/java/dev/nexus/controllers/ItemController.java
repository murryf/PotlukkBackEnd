package dev.nexus.controllers;

import dev.nexus.services.ItemService;
import dev.nexus.services.ItemServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

// @Component: Spring detects classes with this notation.
@Component
// @Controller: Spring identifies controller class with this notation.
@Controller
// @CrossOrigin: This annotation tells Spring to enable CORS
@CrossOrigin("*")
public class ItemController{
    public ItemService itemService;

    public List<Item> retrieveAllItems(){

    }

    public Item
}
