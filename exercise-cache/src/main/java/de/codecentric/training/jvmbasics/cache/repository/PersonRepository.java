package de.codecentric.training.jvmbasics.cache.repository;

import de.codecentric.training.jvmbasics.cache.model.Person;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Repository
public class PersonRepository {

    private static final List<String> names = Arrays.asList("Anna", "Bernd", "Corinna", "Daniel", "Elena", "Florian", "Gundula", "Hans", "Inga", "Jan", "Karin", "Leonard", "Maren", "Nadim", "Oreo", "Paula", "Quelle", "Richard", "Steffi", "Thomas", "Udo", "Vinona", "Wilhelm", "Xandir", "Yuna", "Zaira");
    private static final List<String> surNames = Arrays.asList("Müller", "Schmidt", "Weber", "Fischer", "Schneider", "Meyer", "Wagner", "Becker", "Schulz", "Hoffmann", "Schäfer", "Koch", "Bauer", "Richter", "Klein", "Wolf", "Schröder", "Neumann", "Schwarz", "Zimmermann", "Braun", "Krüger", "Hofmann", "Hartmann", "Lange", "Schmitt");


    public Person findById(Long id) {
        Random random = new Random(id);

        return new Person(id,names.get(random.nextInt(names.size())),surNames.get(random.nextInt(surNames.size())));
    }
}
