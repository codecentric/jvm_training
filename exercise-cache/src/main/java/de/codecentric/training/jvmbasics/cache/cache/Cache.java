package de.codecentric.training.jvmbasics.cache.cache;

public interface Cache<T> {
    T get(Long id);
    void put(Long id, T obj);
    void clear();
    int size();
}
