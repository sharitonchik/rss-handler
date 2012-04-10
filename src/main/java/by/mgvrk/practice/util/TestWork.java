package by.mgvrk.practice.util;

import by.mgvrk.practice.spring.Person;
import by.mgvrk.practice.spring.SequenceGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: sharitonchik
 */
public class TestWork {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/bean.xml");

        SequenceGenerator generator = (SequenceGenerator) context.getBean("sequenceGenerator");

        System.out.println(generator.getSequence());
        System.out.println(generator.getSequence());
        System.out.println(generator.getSequence());

        SequenceGenerator generator1 = (SequenceGenerator) context.getBean("sequenceGenerator");

        System.out.println(generator1.getSequence());
        System.out.println(generator1.getSequence());

        Person person = (Person) context.getBean("sergey");

        System.out.println(person.getName());
    }
}
