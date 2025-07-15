package second;

public class Hard_reverseKGroup {
    public static void main(String[] args) {
        Hard_reverseKGroup t = new Hard_reverseKGroup();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        t.reverseKGroup(listNode,2);

    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        ListNode sentry = new ListNode();
        ListNode result = sentry;

        while(current != null){
            ListNode target = current;
            int i = 1;
            for (; i < k && target != null; i++) {
                target = target.next;
            }
            if(target == null)
                break;

            sentry.next = target.next;
            ListNode reverseTail = current;
            //执行k个元素的翻转
            for (int i1 = 0; i1 < k; i1++) {
                ListNode curNext = current.next;
                current.next = sentry.next;
                sentry.next = current;
                current = curNext;
            }
            sentry = reverseTail;
        }
        return result.next;
    }
}
