package okunoda;

/**
 * @author Okunoda 2024/3/21
 */
public class Medium_AddTwoNumbers {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode l3 = new ListNode();
            ListNode p3 = l3;
            int adder = 0;
            ListNode p1 = l1;
            ListNode p2 = l2;

            int sum = p1.val + p2.val;
            if (sum > 9) {
                adder = sum / 10;
                sum = sum % 10;
            }
            l3.val = sum;
            p1 = p1.next;
            p2 = p2.next;

            while (p1 != null && p2 != null) {
                p3.next = new ListNode();
                p3 = p3.next;
                sum = p1.val + p2.val + adder;
                if (sum > 9) {
                    adder = sum / 10;
                    sum = sum % 10;
                } else {
                    adder = 0;
                }

                p3.val = sum;
                p1 = p1.next;
                p2 = p2.next;
            }
            while (p1 != null) {
                p3.next = new ListNode();
                p3 = p3.next;
                sum = p1.val + adder;
                if (sum > 9) {
                    adder = sum / 10;
                    sum = sum % 10;
                } else {
                    adder = 0;
                }
                p3.val = sum;
                p1 = p1.next;
            }
            while (p2 != null) {
                p3.next = new ListNode();
                p3 = p3.next;
                sum = p2.val + adder;
                if (sum > 9) {
                    adder = sum / 10;
                    sum = sum % 10;
                } else {
                    adder = 0;
                }
                p3.val = sum;
                p2 = p2.next;
            }

            if(adder > 0){
                p3.next = new ListNode(adder);
            }
            return l3;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
//    }
}


