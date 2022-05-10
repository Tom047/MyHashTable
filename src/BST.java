import java.util.PriorityQueue;
import java.util.Queue;

public class BST<K extends Comparable<K>, V> {
    private Node root;

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public BST() {
        root = null;
    }

    public void put(K key, V value) {
        Node n = new Node(key, value);
        root = put(root, n);
    }

    public Node put(Node root, Node n) {
        if (root == null) {
            root = new Node(n.key, n.value);
            return root;
        }

        if (n.key.compareTo(root.key) < 0)
            root.left = put(root.left, n);
        else if (n.key.compareTo(root.key) > 0)
            root.right = put(root.right, n);

        return root;
    }

    public V get(K key) {return null;}

    public void delete(K key) {}

    public Iterable<K> iterator() {
        PriorityQueue<K> q = new PriorityQueue<K>();
        inorder(root, q);
        return q;
    }

    private void inorder(Node n, PriorityQueue<K> q) {
        if(n == null) return;
        inorder(n.left, q);
        q.remove(n.key);
        inorder(n.right, q);
    }
}
