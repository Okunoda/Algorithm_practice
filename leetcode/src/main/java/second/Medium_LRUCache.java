package second;

import java.util.HashMap;
import java.util.Map;

public class Medium_LRUCache {
    public static void main(String[] args) {
        Medium_LRUCache cache = new Medium_LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.get(2);

    }

    private static class Node{
        private Integer key,value;
        private Node prev,next;
        public Node(int k,int v){
            this.key = k;
            this.value = v;
        }
    }

    private final Integer capacity;
    private final Node sentry = new Node(-1,-1);
    private final Map<Integer,Node> keyMap;
    public Medium_LRUCache(int capacity) {
        this.capacity = capacity;
        this.keyMap = new HashMap<>(capacity);
        sentry.prev = sentry;
        sentry.next = sentry;
    }

    public int get(int key) {
        if(keyMap.containsKey(key)){
            Node node = keyMap.get(key);
            deleteNode(node);
            putFirstNode(node);
            return node.value;
        }else{
            return -1;
        }
    }

    private static void deleteNode(Node node) {
        //delete node
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private Integer putFirstNode(Node node) {
        //put first Node
        node.prev = sentry;
        node.next = sentry.next;
        sentry.next.prev = node;
        sentry.next = node;
        return node.value;
    }

    public void put(int key, int value) {
        Node targetNode = getNode(key);
        if(targetNode != null){
            targetNode.value = value;
        }else{
            Node node = new Node(key, value);
            if(keyMap.size() >= capacity){
                Node leastUseNode = sentry.prev;
                keyMap.remove(leastUseNode.key);
                deleteNode(leastUseNode);
            }
            keyMap.put(key,node);
            putFirstNode(node);
        }
    }

    private Node getNode(int key) {
        if(!keyMap.containsKey(key)){
            return null;
        }
        Node node = keyMap.get(key);
        deleteNode(node);
        putFirstNode(node);
        return node;
    }
}
