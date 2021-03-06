package pl.shonsu.asd;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class SimpleHashMap<K, V> implements SimpleMap<K, V> {

    private static final float LOAD_FACTOR = 0.75F;

    private static final int INITIAL_CAPACITY = 4;

    private int size;

    // just for test access
    int threshold;

    // just for test access
    List<Entry<K, V>>[] table;

    private static class Entry<K, V> {

        private final K key;

        private V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public SimpleHashMap() {
        this(INITIAL_CAPACITY);
    }

    public SimpleHashMap(int initialCapacity) {
        table = new List[initialCapacity];
        threshold = (int) (initialCapacity * LOAD_FACTOR);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean keysEqual(K key1, K key2) {
        return Objects.equals(key1, key2);
    }

    @Override
    public V get(K key) {
        Entry<K, V> entry = getEntry(key);
        if (entry == null) {
            return null;
        }
        return entry.value;
    }

    private Entry<K, V> getEntry(K key) {
        int hash = hash(key);
        List<Entry<K, V>> bucket = table[hash];
        if (bucket != null) {
            for (Entry<K, V> entry : bucket) {
                if (keysEqual(key, entry.key)) {
                    return entry;
                }
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int hash = hash(key);
        if (table[hash] == null) {
            table[hash] = new LinkedList<>();
        }
        V oldValue = null;
        boolean keyExist = false;
        List<Entry<K, V>> bucket = table[hash];

        for (Entry<K, V> entry : bucket) {
            if (keysEqual(key, entry.key)) {
                oldValue = entry.value;
                entry.value = value;
                keyExist = true;
                break;
            }
        }

        if (!keyExist) {
            bucket.add(new Entry<>(key, value));
            size++;
        }

        if (size == threshold) {
            resize();
        }

        return oldValue;
    }

    private void resize() {
        if (table.length == Integer.MAX_VALUE) {
            return;
        }

        List<Entry<K, V>>[] oldTable = table;
        table = new List[table.length * 2];
        threshold = (int) (table.length * LOAD_FACTOR);

        for (List<Entry<K, V>> bucket : oldTable) {
            if (bucket == null) {
                continue;
            }
            for (Entry<K, V> entry : bucket) {
                int hash = hash(entry.key);
                if(table[hash] == null) {
                    table[hash] = new LinkedList<>();
                }
                List<Entry<K, V>> newBucket = table[hash];
                newBucket.add(entry);
            }
        }
    }

    private int hash(K key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode() % table.length);
    }

    @Override
    public void clear() {
        size = 0;
        for (int bucketIndex = 0; bucketIndex < table.length; bucketIndex++) {
            table[bucketIndex] = null;
        }
    }

    @Override
    public V remove(K key) {
        List<Entry<K, V>> bucket = table[hash(key)];
        if (bucket == null) {
            return null;
        }

        Iterator<Entry<K, V>> bucketIterator = bucket.iterator();
        V oldValue = null;
        while (bucketIterator.hasNext()) {
            Entry<K, V> entry = bucketIterator.next();
            if (keysEqual(key, entry.key)) {
                oldValue = entry.value;
                bucketIterator.remove();
                size--;
                break;
            }
        }

        if (bucket.isEmpty()) {
            table[hash(key)] = null;
        }

        return oldValue;
    }

    @Override
    public boolean containsKey(K key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(V value) {
        for (List<Entry<K, V>> bucket : table) {
            if (bucket == null) {
                continue;
            }
            for (Entry<K, V> entry : bucket) {
                if(entry.value.equals(value)){
                    return true;
                }
            }
        }
        return false;
    }

}
