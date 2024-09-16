package okunoda;

/**
 * @author Erywim 2024/9/16
 */
public class Hard_mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        //两两合并
        ListNode prev = lists[0];
        for (int i = 1; i < lists.length; i++) {
            prev = mergeList(prev, lists[i]);
        }

        return prev;
    }

    private ListNode mergeList(ListNode headA , ListNode headB){
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        ListNode first = new ListNode();
        ListNode tmpNew = first;
        while(tmpB != null && tmpA != null){
            if(tmpA.val < tmpB.val){
                tmpNew.next = tmpA;
                tmpA = tmpA.next;
                tmpNew = tmpNew.next;
                tmpNew.next = null;
            }else{
                tmpNew.next = tmpB;
                tmpB = tmpB.next;
                tmpNew = tmpNew.next;
                tmpNew.next = null;
            }
        }
        if(tmpA != null){
            tmpNew.next = tmpA;
        }
        if(tmpB != null){
            tmpNew.next = tmpB;
        }
        return first.next;
    }

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
}
