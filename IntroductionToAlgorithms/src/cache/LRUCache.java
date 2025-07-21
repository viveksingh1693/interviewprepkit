package cache;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    private int capacity;
    private Map<Integer, Node> cacheMap;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {

        if (!cacheMap.containsKey(key)) {
            return -1;
        }
        Node node = cacheMap.get(key);
        remove(node);
        add(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(cacheMap.containsKey(key)){
            Node oldNode = cacheMap.get(key);
            remove(oldNode);
        }

        Node newNode = new Node(key,value);
        cacheMap.put(key,newNode);
        add(newNode);
        if(cacheMap.size() > capacity){
            Node leastUsed = tail.prev;
            remove(leastUsed);
            cacheMap.remove(leastUsed.key);
        }
    }

    private void add(Node node) {
        Node nextNode = head.next;
        node.next = nextNode;
        node.prev = head;
        head.next = node;
        nextNode.prev = node;
    }

    private void remove(Node node) {
        Node nextNode = node.next;
        Node prevNode = node.prev;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}