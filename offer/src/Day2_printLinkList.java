/**
 * @author Okunoda
 * @date 2023年02月23日22:54
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Day2_printLinkList {
    int[] nums = new int[10000];
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    class Solution {
        public int[] reversePrint(ListNode head) {
            ListNode item = head;
            int count = 0;
            while(item!=null){
                count++;
                item = item.next;
            }
            int[] res = new int[count];
            while(head!=null){
                res[--count] = head.val;
                head = head.next;
            }
            return res;
        }
    }
}
