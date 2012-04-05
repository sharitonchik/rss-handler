package by.mgvrk.practice.util;

import by.mgvrk.practice.spring.SequenceGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

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
        System.out.println(generator.getSequence());
        System.out.println(generator.getSequence());
    }
}
