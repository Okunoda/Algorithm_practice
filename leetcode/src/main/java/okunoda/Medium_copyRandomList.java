package okunoda;


import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Erywim 2024/9/14
 */
public class Medium_copyRandomList {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Map<Node, Node> oldMapNew = new HashMap<>();
        Node idxA = head;
        Node newNode = new Node(idxA.val);
        Node idxB = newNode;
        oldMapNew.put(idxA,idxB);
        while(idxA.next != null){
            idxA = idxA.next;
            Node nextB = new Node(idxA.val);
            idxB.next = nextB;
            idxB = idxB.next;
            oldMapNew.put(idxA,idxB);
        }

        idxB = newNode;
        idxA = head;
        while(idxB != null){
            Node random = idxA.random;
            if (random != null) {
                Node node = oldMapNew.get(random);
                idxB.random = node;
            }
            idxB = idxB.next;
            idxA = idxA.next;
        }

        return newNode;
    }
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
