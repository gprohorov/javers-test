package dev.bo.javerstest.repository;


/*
  @author   oleh
  @project   proj-test
  @class  ItemRepository
  @version  1.0.0 
  @since 09.09.24 - 12.27
*/

import dev.bo.javerstest.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
}
