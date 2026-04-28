import java.util.*;

public class HashTableImplementation {

    private static class HashNode {
        String key;
        int value;
        HashNode next;

        HashNode(String key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private LinkedList<HashNode>[] bucketArray;
    private int numBuckets;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTableImplementation(int numBuckets) {
        this.numBuckets = numBuckets;
        this.size = 0;
        bucketArray = new LinkedList[numBuckets];
        for (int i = 0; i < numBuckets; i++) {
            bucketArray[i] = new LinkedList<>();
        }
    }

    private int getBucketIndex(String key) {
        return Math.abs(key.hashCode()) % numBuckets;
    }

    public void put(String key, int value) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<HashNode> bucket = bucketArray[bucketIndex];

        // Check if key already exists
        for (HashNode node : bucket) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }

        // Key doesn't exist, add new node
        bucket.add(new HashNode(key, value));
        size++;
    }

    public Integer get(String key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<HashNode> bucket = bucketArray[bucketIndex];

        for (HashNode node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public boolean remove(String key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<HashNode> bucket = bucketArray[bucketIndex];

        for (HashNode node : bucket) {
            if (node.key.equals(key)) {
                bucket.remove(node);
                size--;
                return true;
            }
        }
        return false;
    }

    public boolean containsKey(String key) {
        return get(key) != null;
    }

    public int size() {
        return size;
    }

    public void display() {
        for (int i = 0; i < numBuckets; i++) {
            System.out.print("Bucket " + i + ": ");
            for (HashNode node : bucketArray[i]) {
                System.out.print("(" + node.key + ", " + node.value + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HashTableImplementation hashTable = new HashTableImplementation(5);

        hashTable.put("Alice", 25);
        hashTable.put("Bob", 30);
        hashTable.put("Charlie", 35);
        hashTable.put("David", 40);

        System.out.println("Hash Table contents:");
        hashTable.display();

        System.out.println("\nGet Alice: " + hashTable.get("Alice"));
        System.out.println("Contains Bob: " + hashTable.containsKey("Bob"));
        System.out.println("Size: " + hashTable.size());

        hashTable.remove("Bob");
        System.out.println("\nAfter removing Bob:");
        hashTable.display();
        System.out.println("Size: " + hashTable.size());
    }
}