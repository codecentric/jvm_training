package de.codecentric.training.jvmbasics.cache.cache;

import java.util.Hashtable;
import java.util.Map;

public class SimpleCache<T> implements Cache<T> {
    private final Map<Long, T> cache = new Hashtable<>();

    @Override
    public T get(Long id) {
        return cache.get(id);
    }

    @Override
    public void put(Long id,T person) {
        cache.put(id,person);
        if (size() % 1000 == 0) {
            System.out.println("Cachesize: " + size());
        }
    }

    @Override
    public int size() {
        return cache.size();
    }

    @Override
    public void clear() {
        System.out.println("cache cleared");
        cache.clear();
    }
}
