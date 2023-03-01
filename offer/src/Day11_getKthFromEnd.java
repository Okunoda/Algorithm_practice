/**
 * @author Okunoda
 * @date 2023年03月01日23:51
 */
public class Day11_getKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = head;
        ListNode rear = head;
        while(k-->0)
            rear = rear.next;
        while(rear!=null){
            pre = pre.next;
            rear = rear.next;
        }
        return pre;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
