/**
 * @author Okunoda
 * @date 2023年03月01日23:41
 */
public class Day11_deleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if(head==null)return null;
        ListNode current = head;
        ListNode pre = null;
        while(current.val!=val){
            pre = current;
            current = current.next;
        }
        if(pre == null){
            head = head.next;
        }else{
            pre.next = current.next;
        }
        return head;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
