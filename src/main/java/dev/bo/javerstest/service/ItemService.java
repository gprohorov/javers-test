package dev.bo.javerstest.service;


/*
  @author george
  @project   proj-test
  @class  ItemService
  @version  1.0.0 
  @since 09.09.24 - 12.16
*/



import dev.bo.javerstest.model.Item;
import dev.bo.javerstest.repository.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.javers.core.Changes;
import org.javers.core.diff.Change;
import org.javers.spring.annotation.JaversAuditable;
import org.javers.spring.annotation.JaversAuditableDelete;
import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    private final List<Item> items = new ArrayList<>();
    {
        items.add(new Item( "name1", "000001","description1"));
        items.add(new Item( "name2", "000002","description3"));
        items.add(new Item( "name3", "000003","description3"));
    }

    //  @PostConstruct
    void init() {
        for (Item item : items) {
            this.create(item);
        }
    }
    //  CRUD   - create read update delete

    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    public Item getById(String id) {
        return itemRepository.findById(id).orElse(null);
    }

    @JaversAuditable
    public Item create(Item item) {
        return itemRepository.save(item);
    }


    @JaversAuditable
    public  Item update(Item item) {
        Item oldItem = getById(item.getId());
        if (oldItem == null) {
            return null;
        }
        item.setCreatedDate(oldItem.getCreatedDate());
        item.setCreatedBy(oldItem.getCreatedBy());

        return itemRepository.save(item);
    }


    public void delById(String id) {
        Item item = getById(id);
      delete(item);
    }

    @JaversAuditableDelete
    private void delete(Item item) {
        itemRepository.delete(item);
    }
}
