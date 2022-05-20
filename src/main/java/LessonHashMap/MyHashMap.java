package LessonHashMap;

import java.util.Optional;

public class MyHashMap<K, V> {

    private int INIT_SIZE = 16;
    private Node<K, V>[] table = new Node[INIT_SIZE];
    private int size;
    private int threshold;

    public MyHashMap() {
        setThreshold();
    }

    public void put(K key, V value) {

        int numBucket = getNumBucket(key);

        Node<K, V> findNode = getNode(key);

        if (findNode != null) {
            findNode.value = value;
            return;
        }

        table[numBucket] = new Node<>(key, value, null);

        if (++size > threshold) {
            resize();
        }
    }

    public int getNumBucket(K key) {
        return key == null ? 0 : key.hashCode() % table.length;
    }

    public V get(K key) {

        Node<K, V> findNode = getNode(key);

        if (findNode == null) {
            return null;
        }

        return findNode.value;

    }

    public boolean containsKey(K key) {

        Node<K, V> findNode = getNode(key);

        return findNode != null;

    }

    public boolean containsValue(V value) {

        for (Node<K, V> thisNode : table) {
            if (thisNode != null) {
                if (thisNode.value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Node<K, V> getNode(K key) {

        int numBucket = getNumBucket(key);
        if (table[numBucket] == null) {
            return null;
        } else {
            Node<K, V> node = table[numBucket];

            for (Node nodes = node; node.next != null; nodes = node.next) {
                if (nodes.key.equals(key)) {
                    return nodes;
                }
            }

            if (node.key.equals(key)) {
                return node;
            }

        }
        return null;
    }

    private class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public int size() {
        return size;
    }

    private void resize() {

        Node<K, V>[] newTable = new Node[table.length * 2];
        setThreshold();

        for (Node<K, V> thisNode : table) {
            if (thisNode != null) {
                newTable[getNumBucket(thisNode.key)] = thisNode;
            }
        }

        table = newTable;
    }

    private void setThreshold() {
        threshold = (int) (table.length * 0.7);
    }
}
