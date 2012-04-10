package by.mgvrk.practice.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * User: sharitonchik
 */
@Configuration
public class PersonConfiguration {

    @Bean
    public Person sergey() {
        Person person = new Person();
        person.setName("sergey");
        person.setSurname("haritonchik");

        return person;
    }
}
