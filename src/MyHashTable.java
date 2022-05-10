import java.util.ArrayList;

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

    private ArrayList<HashNode<K, V>> chainArray;
    private int M = 11;
    private int size;

    public MyHashTable() {
        chainArray = new ArrayList<>(M);
        size = 0;

        for (int i = 0; i < M; i++)
            chainArray.add(null);
    }

    public MyHashTable(int M) {
        this.M = M;
        chainArray = new ArrayList<>(M);
        size = 0;

        for (int i = 0; i < M; i++)
            chainArray.add(null);
    }

    private int hash(K key) {
        return (hashCode(key) & 0x7fffffff) % M;
    }

    private int hashCode(K key) {
        return java.lang.System.identityHashCode(key);
    }

    public void put(K key, V value) {}

    public V get(K key) {
        int index = hash(key);
        while(chainArray.get(index) != null) {

            if(chainArray.get(index).key == key)
            return chainArray.get(index).value;

            index++;

            index %= M;
        }

        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> head = chainArray.get(0);
        HashNode<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key) && hashCode(key) == hashCode(head.key))
                break;

            prev = head;
            head = head.next;
        }

        if (head == null)
            return null;

        size--;

        if (prev != null)
            prev.next = head.next;
        else
            chainArray.set(index, head.next);

        return head.value;
    }

    public boolean contains(V value) {return false;}

    public K getKey(V value) {return null;}
}
