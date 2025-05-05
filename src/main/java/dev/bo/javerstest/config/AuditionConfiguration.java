package dev.bo.javerstest.config;


/*
  @author   george
  @project   proj-test
  @class  AuditionConfiguration
  @version  1.0.0 
  @since 10.04.25 - 13.18
*/



import com.mongodb.client.MongoClient;
import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.repository.mongo.MongoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@Configuration
public class AuditionConfiguration {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }
//
//    @Bean
//    public Javers javers() {
//        MongoRepository javersMongoRepository =
//                new MongoRepository(mongo().getDatabase("javers-db"));
//
//        return JaversBuilder.javers()
//                .registerJaversRepository(javersMongoRepository)
//                .build();
//    }
//
//    @Bean
//    public MongoClient mongo() {
//        return new MongoClient();
//    }




}
