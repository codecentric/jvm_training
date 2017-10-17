package de.codecentric.training.jvmbasics.cache.cache;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Hashtable;
import java.util.Map;

public class SmartSoftRefCache<T> implements Cache<T> {
    private final Map<Long, SoftReference<T>> cache = new Hashtable<>();
    private final ReferenceQueue<T> queue = new ReferenceQueue<>();

    @Override
    public T get(Long key) {
        T result = null;
        SoftReference<T> ref = cache.get(key);
        if (ref != null) {
            result = ref.get();
            if (result == null) {
                cache.remove(key);
            }
        }
        return result;
    }

    @Override
    public void put(Long id, T obj) {
        processQueue();
        cache.put(id, new SoftReferenceWithKeyInfo(obj, id, queue));
        System.out.println("Cachesize: " + size());
    }

    private void processQueue() {
        SoftReferenceWithKeyInfo sv;
        while ((sv = (SoftReferenceWithKeyInfo) queue.poll()) != null) {
            cache.remove(sv.key);
        }
    }

    @Override
    public int size() {
        return cache.size();
    }

    @Override
    public void clear() {
        processQueue();
        cache.clear();
    }

    private static class SoftReferenceWithKeyInfo<T> extends SoftReference<T> {
        /**
         * The key where the referenced BigObject is stored at. Used to later be able to quickly remove the mapping from
         * the map.
         */
        private final Long key;
        private SoftReferenceWithKeyInfo(T o, Long key, ReferenceQueue<T> queue) {
            super(o, queue);
            this.key = key;
        }
    }
}
