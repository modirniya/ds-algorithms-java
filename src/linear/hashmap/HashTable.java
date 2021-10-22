package linear.hashmap;


import java.util.LinkedList;

public class HashTable {

    public HashTable(int initialCapacity) {
        table = new LinkedList[3];
    }

    private final LinkedList<Entry>[] table;

    private class Entry {
        private int key;

        private String value;


        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value='" + value + '\'' +
                    '}';
        }

    }

    public void put(int key, String value) {
        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

        final var bucket = getOrCreateBucket(key);
        bucket.addLast(new Entry(key, value));
    }

    public String get(int key) {
        final var entry = getEntry(key);
        return entry == null ? null : entry.value;
    }

    public String remove(int key) {
        var entry = getEntry(key);
        if (entry == null)
            throw new IllegalArgumentException("Key doesn't exist");
        getBucket(key).remove(entry);
        return entry.value;
    }

    private Entry getEntry(int key) {
        var bucket = getBucket(key);
        if (bucket != null)
            for (Entry entry : bucket)
                if (entry.key == key)
                    return entry;
        return null;
    }

    private LinkedList<Entry> getBucket(int key) {
        return table[hash(key)];
    }

    private LinkedList<Entry> getOrCreateBucket(int key) {
        final var index = hash(key);
        var bucket = table[index];
        return (bucket == null) ?
                new LinkedList<>() : bucket;
    }

    private int hash(int key) {
        return key % table.length;
    }

}
