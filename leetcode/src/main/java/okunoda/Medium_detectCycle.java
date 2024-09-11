package okunoda;

import java.util.HashSet;

/**
 * @author Erywim 2024/9/11
 */
public class Medium_detectCycle {
    /**
     * 快慢指针的方式需要一定的推理，这个方法使用的是哈希运算，稍微慢一些，但是容易想到
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode tmp = head;
        while(tmp!=null){
            if(set.contains(tmp)){
                return tmp;
            }else{
                set.add(tmp);
            }
            tmp = tmp.next;
        }
        return null;
    }
}
