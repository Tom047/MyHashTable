public class MyHashTable<K, V> {

    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private Object[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable() {
        chainArray = new Object[M];
    }

    public MyHashTable(int M) {
        this.M = M;
        chainArray = new Object[this.M];
    }

    private int hash(K key) {
        int hash = java.lang.System.identityHashCode(key);
        return (hash & 0x7fffffff) % M;
    }

    public void put(K key, V value) {}

    public V get(K key) {return null;}

    public V remote(K key) {return null;}

    public boolean contains(V value) {return false;}

    public K getKey(V value) {return null;}
}
