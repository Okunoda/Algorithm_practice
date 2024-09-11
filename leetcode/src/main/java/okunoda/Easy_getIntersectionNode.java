package okunoda;

/**
 * @author Erywim 2024/9/6
 */
public class Easy_getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        int lengthA = 0, lengthB = 0;
        //获取长度
        while (tempA != null) {
            lengthA++;
            tempA = tempA.next;
        }
        while (tempB != null) {
            lengthB++;
            tempB = tempB.next;
        }
        //长的固定分配给A
        if (lengthA > lengthB) {
            tempA = headA;
            tempB = headB;
        } else {
            tempA = headB;
            tempB = headA;
            int temp = lengthB;
            lengthB = lengthA;
            lengthA = temp;
        }
        //对齐长度
        for (int i = 0; i < lengthA - lengthB; i++) {
            tempA = tempA.next;
        }
        //找到相交
        while (tempA != null && tempB != null && tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        if (tempA == null || tempB == null) {
            return null;
        } else {
            return tempA;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
    ListNode(){

    }
}
