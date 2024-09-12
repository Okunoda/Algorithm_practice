package okunoda;

/**
 * @author Erywim 2024/9/12
 */
public class Hard_reverseKGroup {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);
        Hard_reverseKGroup entity = new Hard_reverseKGroup();
        ListNode listNode1 = entity.reverseKGroup(listNode, 2);
        System.out.println(listNode1.val);
    }

    /**
     * 还是链表好玩
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = new ListNode();
        first.next = head;

        ListNode tmp = first.next;
        ListNode tmpPrev = first;
        while (tmp != null) {
            int i = 0;
            ListNode start = tmpPrev;
            while (i++ < k && tmp != null) {
                tmp = tmp.next;
            }
            if (tmp == null && i <= k) {
                break;//如果i<=k就是说明这次是想要转换的长度大于当前链表剩余的长度
            }//否则就是反转整个链表

            tmpPrev = reverse(start, k);
        }
        return first.next;
    }

    public ListNode reverse(ListNode prev, int k) {
        ListNode idx = prev.next;
        while (--k > 0 && idx.next != null) {
            ListNode tmp = idx.next;
            idx.next = tmp.next;
            tmp.next = prev.next;
            prev.next = tmp;
        }
        return idx;
    }
}
