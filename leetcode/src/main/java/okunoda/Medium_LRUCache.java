package okunoda;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Erywim 2024/9/16
 */
public class Medium_LRUCache {
    static class LRUCache {
        class Node {
            Node prev;
            Node next ;
            Integer key ;
            Integer val;
            public Node(Integer key ,Integer val){
                this.key = key;
                this.val = val;
                this.prev = null;
                this.next = null;
            }
        }

        Map<Integer, Node> map = new HashMap<>();
        Node sentry = new Node(0, 0);
        Integer capacity ;
        int size = 0;

        public LRUCache(int capacity) {
            sentry.next = sentry;
            sentry.prev = sentry;
            this.capacity = capacity;
        }

        public int get(int key) {
            if(map.containsKey(key)){
                Node node = map.get(key);
                node.prev.next = node.next;
                node.next.prev = node.prev;
                putFirstNode(node);
                return node.val;
            }else{
                return -1;
            }
        }

        public void put(int key, int value) {
            Node node;
            if(map.containsKey(key)){
                //摘离出这个点
                node = map.get(key);
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.val = value;
                //放到首位
            }else{
                node = new Node(key, value);
                if(size < capacity){
                    size++;
                }else{
                    Node lastNode = sentry.prev;
                    lastNode.prev.next = lastNode.next;
                    sentry.prev = lastNode.prev;
                    map.remove(lastNode.key);
                }
                map.put(key,node);
            }
            putFirstNode(node);
        }

        private void putFirstNode(Node node) {
            sentry.next.prev = node;
            node.next = sentry.next;
            sentry.next = node;
            node.prev = sentry;
        }
    }
}


