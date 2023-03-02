/**
 * @author Okunoda
 * @date 2023年03月02日9:53
 */
public class Day12_getIntersectionNode {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int countA , countB;
        countA = countB =0;
        while(curA != null ){
            countA++;
            curA=curA.next;
        }
        while(curB != null){
            countB++;
            curB = curB.next;
        }
        int gap = Math.abs(countA - countB);
        if(countA > countB ){
            while(gap-->0)
                headA = headA.next;
        }else{
            while(gap-->0)
                headB = headB.next;
        }
        while(headA!=null&&headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
