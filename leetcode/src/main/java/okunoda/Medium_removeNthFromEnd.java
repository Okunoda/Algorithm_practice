package okunoda;

/**
 * @author Erywim 2024/9/11
 */
public class Medium_removeNthFromEnd {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        Medium_removeNthFromEnd entity = new Medium_removeNthFromEnd();
        ListNode listNode1 = entity.removeNthFromEnd(listNode, 2);
        System.out.println("listNode1.val = " + listNode1.val);
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null ||head.next==null){
            return null;
        }
        ListNode first = new ListNode();
        first.next = head;
        ListNode fast = first;
        ListNode slow = first;
        ListNode prev = first;
        while(fast != null){
            fast = fast.next;
            if(--n < 0){
                prev = slow;
                slow = slow.next;
            }
        }

        prev.next = slow.next;
        return first.next;
    }
}
