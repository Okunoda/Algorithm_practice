package okunoda;

/**
 * @author Erywim 2024/9/9
 */
public class Easy_reverseList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode tmpHead = new ListNode();
        tmpHead.next = head;

        ListNode prev = tmpHead.next;
        tmpHead.next = null;
        while(prev != null){
            ListNode tmp = prev.next;
            prev.next = tmpHead.next;
            tmpHead.next = prev;
            prev = tmp;
        }
        return tmpHead.next;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}


