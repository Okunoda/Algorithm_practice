package okunoda;

/**
 * @author Erywim 2024/9/11
 */
public class Medium_swapPairs {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        Medium_swapPairs entity = new Medium_swapPairs();
        ListNode listNode1 = entity.swapPairs(listNode);
        System.out.println(listNode1.val);
    }
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode first = new ListNode();
        first.next = head;
        ListNode left = null , right, prev = first;
        ListNode tmp = first.next;
        int i = 1;
        while(tmp != null){
            if(i++%2 == 1){
                left = tmp;
                tmp = tmp.next;
            }else{
                right = tmp;
                left.next = right.next;
                right.next = left;
                prev.next = right;
                prev = left;
                tmp = left.next;
            }
        }
        return first.next;
    }
}
