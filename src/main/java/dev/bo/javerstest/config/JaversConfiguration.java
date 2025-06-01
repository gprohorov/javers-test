package dev.bo.javerstest.config;


/*
  @author   george
  @project   javers-test
  @class  JaversConfiguration
  @version  1.0.0 
  @since 22.04.25 - 20.21
*/

import org.javers.spring.auditable.AuthorProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JaversConfiguration {
    private static class SimpleAuthorProvider implements AuthorProvider {
        @Override
        public String provide() {
            return "ADMIN";
        }
    }
    @Bean
    public AuthorProvider provideJaversAuthor() {

        return new SimpleAuthorProvider();
    }

}
