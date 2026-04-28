import java.util.*;

public class CustomHashMap<K, V> {
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node<K, V>[] table;
    private int count;

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        table = new Node[16];
    }

    private int index(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    public void put(K key, V value) {
        int i = index(key);
        Node<K, V> curr = table[i];

        while (curr != null) {
            if (curr.key.equals(key)) {
                curr.value = value;
                return;
            }
            curr = curr.next;
        }

        Node<K, V> nextNode = new Node<>(key, value);
        nextNode.next = table[i];
        table[i] = nextNode;
        count++;
    }

    public V get(K key) {
        Node<K, V> curr = table[index(key)];
        while (curr != null) {
            if (curr.key.equals(key)) return curr.value;
            curr = curr.next;
        }
        return null;
    }

    public void remove(K key) {
        int i = index(key);
        Node<K, V> curr = table[i], prev = null;

        while (curr != null) {
            if (curr.key.equals(key)) {
                if (prev == null) table[i] = curr.next;
                else prev.next = curr.next;
                count--;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public int size() {
        return count;
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("Apple", 100);
        map.put("Banana", 150);
        System.out.println("Size: " + map.size());
        System.out.println("Apple: " + map.get("Apple"));
        map.remove("Apple");
        System.out.println("Apple after move: " + map.get("Apple"));
    }
}
