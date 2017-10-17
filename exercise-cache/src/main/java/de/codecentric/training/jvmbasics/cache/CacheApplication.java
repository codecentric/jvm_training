package de.codecentric.training.jvmbasics.cache;

import de.codecentric.training.jvmbasics.cache.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.stream.LongStream;

@SpringBootApplication
public class CacheApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =  SpringApplication.run(CacheApplication.class, args);

        PersonService personService = context.getBean(PersonService.class);
//
//        System.out.println("Load VIPs");
//        LongStream.range(0,20000).forEach(i -> {
//            personService.getById(i);
//        });
//        System.out.println("All VIPs loaded");
    }
}
