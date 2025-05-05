package dev.bo.javerstest.repository;


/*
  @author   george
  @project   proj-test
  @class  ItemRepository
  @version  1.0.0 
  @since 09.09.24 - 12.27
*/

import dev.bo.javerstest.model.Item;
import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@JaversSpringDataAuditable
@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
}
