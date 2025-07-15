package second;

public class Easy_reverseList {
    public class ListNode {
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

    public ListNode reverseList(ListNode head) {
        ListNode sentry = new ListNode();
        ListNode current = head;

        while(current != null){
            ListNode curNext = current.next;
            current.next = sentry.next;
            sentry.next = current;
            current = curNext;
        }
        return sentry.next;
    }
}
