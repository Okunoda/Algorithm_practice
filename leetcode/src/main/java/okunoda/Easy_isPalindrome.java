package okunoda;

import java.util.Stack;

/**
 * @author Erywim 2024/9/9
 */
public class Easy_isPalindrome {
    /**
     * 通过将前半段入栈，后半段以此跟栈顶匹配进行判断
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null ||head.next == null) return true;
        ListNode tmp = head;
        int len = 0;
        while (tmp != null) {
            tmp = tmp.next;
            len++;
        }
        tmp = head;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len / 2; i++) {
            stack.push(tmp.val);
            tmp = tmp.next;
        }
        if(len % 2 != 0 ){
            stack.pop();
        }
        while(tmp != null && !stack.empty()){
            Integer pop = stack.pop();
            if (pop != tmp.val) return false;
            tmp = tmp.next;
        }
        if(tmp == null && stack.empty())
            return true;
        return false;
    }
}
