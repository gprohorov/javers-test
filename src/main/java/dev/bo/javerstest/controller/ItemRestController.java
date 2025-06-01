package dev.bo.javerstest.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import dev.bo.javerstest.model.*;
import dev.bo.javerstest.service.*;
import java.util.List;

/*
  @author   george
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
    Item item = new Item("name1", "000001","");
    int counter = 0;

    @GetMapping
    public List<Item> showAll() {
        return itemService.getAll();
    }

    @GetMapping("/test")
    public Item test() {

     //   System.out.println(" test" + counter);
        item.setDescription("test javers " + counter++);
        return itemService.create(item);
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
