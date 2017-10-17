package de.codecentric.training.jvmbasics.cache.cache;

import de.codecentric.training.jvmbasics.cache.model.Person;

import java.lang.ref.SoftReference;
import java.util.Hashtable;
import java.util.Map;

public class SoftRefCache<T> implements Cache<T> {
    private final Map<Long, SoftReference<T>> cache = new Hashtable<>();

    @Override
    public T get(Long id) {
        SoftReference<T> ref = cache.get(id);
        return ref != null ? ref.get() : null;
    }

    @Override
    public void put(Long id, T person) {
        cache.put(id,new SoftReference<T>(person));
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
        cache.clear();
    }
}
