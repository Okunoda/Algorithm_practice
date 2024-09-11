package okunoda;

/**
 * @author Erywim 2024/9/11
 */
public class easy_mergeTwoLists {
    /**
     * 要是做所有题都能像这样秒杀该多好
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode tmp = head;
        while(list1 != null && list2 != null){
            if(list1.val > list2.val){
                tmp.next = list2;
                list2 = list2.next;
            }else{
                tmp.next = list1;
                list1 = list1.next;
            }
            tmp = tmp.next;
        }

        while(list1 != null){
            tmp.next = list1;
            list1 = list1.next;
            tmp = tmp.next;
        }
        while(list2 != null){
            tmp.next = list2;
            list2 = list2.next;
            tmp = tmp.next;
        }
        return head.next;
    }
}
