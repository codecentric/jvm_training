package de.codecentric.training.jvmbasics.cache.service;

import de.codecentric.training.jvmbasics.cache.cache.Cache;
import de.codecentric.training.jvmbasics.cache.cache.SimpleCache;
import de.codecentric.training.jvmbasics.cache.cache.SmartSoftRefCache;
import de.codecentric.training.jvmbasics.cache.cache.SoftRefCache;
import de.codecentric.training.jvmbasics.cache.model.Person;
import de.codecentric.training.jvmbasics.cache.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/person")
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    private final static Cache<Person> CACHE = new SimpleCache<>();
//    private final static Cache<Person> CACHE = new SoftRefCache<>();
//    private final static Cache<Person> CACHE = new SmartSoftRefCache<>();

    @RequestMapping("/{id}")
    public Person getById(@PathVariable Long id){
        Person fromCache = CACHE.get(id);
        if(fromCache == null){
           fromCache = personRepository.findById(id);
           if(personRepository.findById(id) == null){
               return null;
           };
           CACHE.put(id,fromCache);
        }

        return fromCache;
    }
}
