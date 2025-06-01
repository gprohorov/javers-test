package dev.bo.javerstest.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import dev.bo.javerstest.model.*;
import dev.bo.javerstest.service.*;
import java.util.List;

/*
  @author   oleh
  @project   proj-test
  @class  ItemRestController
  @version  1.0.0 
  @since 09.09.24-12.01
*/
@RestController
@RequestMapping("api/v1/items")
@RequiredArgsConstructor
public class ItemRestController {

    private final ItemService itemService;

    @GetMapping
    public List<Item> showAll() {
        return itemService.getAll();
    }

    @GetMapping("{id}")
    public Item showOneById(@PathVariable String id) {
        return itemService.getById(id);
    }

    @PostMapping
    public Item insert(@RequestBody Item item) {
        return itemService.create(item);
    }

    @PutMapping
    public Item edit(@RequestBody Item item) {
        return itemService.update(item);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        itemService.delById(id);
    }

}
