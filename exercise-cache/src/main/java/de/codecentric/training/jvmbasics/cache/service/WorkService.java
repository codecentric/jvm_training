package de.codecentric.training.jvmbasics.cache.service;

import de.codecentric.training.jvmbasics.cache.cache.Cache;
import de.codecentric.training.jvmbasics.cache.cache.SimpleCache;
import de.codecentric.training.jvmbasics.cache.model.Person;
import de.codecentric.training.jvmbasics.cache.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.LongStream;

@RestController()
public class WorkService {

    @Autowired
    private PersonService personService;

    @RequestMapping("/work")
    public void doSomeWork(){
        long start = System.nanoTime();
        System.out.println("Simulate some work start");
        LongStream.range(0,20000).forEach(i -> {
            personService.getById(start + i);
        });
        System.out.println("Simulate some work done");
    }
}
