package LessonHashMap;

public class MyHashMap<K, V> {

    final int HASHMAP_SIZE = 16;
    private Node<K, V>[] table = new Node[HASHMAP_SIZE];
    private int size;
    private int threshold;

    public MyHashMap() {
        setThreshold();
    }

    public void put(K key, V value) {


        int numBucket = getNumBucket(key);

        Node<K, V> findNode = getNode(key);

        if (findNode == null) {
            table[numBucket] = new Node<>(key, value, null);
        } else {
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

        if (findNode == null) {
            return false;
        }

        return true;

    }

    public boolean containsValue(V value) {

        for (Node<K, V> thisNode : table) {
            if (thisNode != null) {

                if (thisNode.value.equals(value)) {
                    return true;
                }

                for (; thisNode.next != null; thisNode = thisNode.next) {
                    if (thisNode.value.equals(value)) {
                        return true;
                    }
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
            if (node.next != null) {
                for (Node nodes = node; node.next != null; nodes = node.next) {
                    if (nodes.key.equals(key)) {
                        return nodes;
                    }
                }
            } else {
                if (node.key.equals(key)) {
                    return node;
                }
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
        System.arraycopy(table, 0, newTable, 0, table.length);
        table = newTable;
        setThreshold();
    }

    private void setThreshold(){
        threshold = (int) (table.length * 0.7);
    }
}
