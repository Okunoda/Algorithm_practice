package okunoda;

/**
 * @author Erywim 2024/9/11
 */
public class Easy_hasCycle {
    /**
     * 快慢指针，秒杀
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(slow != null && fast != null){
            slow = slow.next;
            fast = fast.next;
            if(fast != null ){
                fast = fast.next;
            }else{
                return false;
            }
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
