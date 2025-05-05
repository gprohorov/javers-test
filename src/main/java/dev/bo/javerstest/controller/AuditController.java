package dev.bo.javerstest.controller;


/*
  @author   george
  @project   javers-test
  @class  AuditController
  @version  1.0.0 
  @since 22.04.25 - 20.40
*/

import dev.bo.javerstest.model.Item;
import org.javers.core.Changes;
import org.javers.core.Javers;
import org.javers.core.diff.Change;
import org.javers.repository.jql.QueryBuilder;
import org.javers.shadow.Shadow;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/audit")
public class AuditController {

    private final Javers javers;

    public AuditController(Javers javers) {
        this.javers = javers;
    }

    @GetMapping("/items")
    public ResponseEntity<String> getItemsChanges() {

        QueryBuilder jqlQuery = QueryBuilder.byClass(Item.class);
        List<Change> changes = javers.findChanges(jqlQuery.build());

        return ResponseEntity.ok().body(javers.getJsonConverter().toJson(changes));
    }

    @GetMapping("/shadows")
    public ResponseEntity<String> getItemsShadows() {

        QueryBuilder jqlQuery = QueryBuilder.byClass(Item.class);
        List<Shadow<Item>> shadows = javers.findShadows(jqlQuery.build());

        return ResponseEntity.ok().body(javers.getJsonConverter().toJson(shadows));
    }

    @GetMapping("/shadows/{id}")
    public ResponseEntity<String> getItemShadow(@PathVariable String id) {
        QueryBuilder jqlQuery = QueryBuilder.byInstanceId(id, Item.class)
                .withNewObjectChanges();
        List<Shadow<Item>> shadows = javers.findShadows(jqlQuery.build());
        return ResponseEntity.ok().body(javers.getJsonConverter().toJson(shadows));
    }

    @GetMapping("/item/{id}")
    public String getItemChanges(@PathVariable String id) {

        QueryBuilder jqlQuery = QueryBuilder.byInstanceId(id, Item.class)
                .withNewObjectChanges();
        Changes changes = javers.findChanges(jqlQuery.build());

        return "<pre>" + changes.prettyPrint() + "</pre>";
    }


}
