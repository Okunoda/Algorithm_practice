import java.util.HashMap;
import java.util.Map;

/**
 * @author Okunoda
 * @date 2023年02月24日11:13
 */

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    //第一版的想法，以为各个节点的值是他们的下标
//    public Node copyRandomList(Node head) {
//        int count = 0;
//        Node temp = head;
//        while(temp!=null){
//            temp = temp.next;
//            count++;
//        }
//        Node[] nodes = new Node[count];
//        temp = head;
//        nodes[0] = new Node(temp.val);
//        Node pre = nodes[0];
//        temp = temp.next;//这里用do-while会比较雅观
//        for(int i = 1 ; i<count;i++){
//            nodes[i] = new Node(temp.val);
//            temp = temp.next;
//            pre.next = nodes[i];
//        }
//
//        for(int i = 0 ;i<count;i++){
//            if(head.next!=null){
//                nodes[i].next = nodes[head.next.val];
//            }else{
//                nodes[i].next= null;
//            }
//            if(head.random!=null){
//                nodes[i].random = nodes[head.random.val];
//            }else{
//                nodes[i].random = null;
//            }
//            head = head.next;
//        }
//        return nodes[0];
//    }

    //第一次见哈希表的运用
        public Node copyRandomList(Node head) {
            if(head == null) return null;
            Node cur = head;
            Map<Node, Node> map = new HashMap<>();
            // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
            while(cur != null) {
                map.put(cur, new Node(cur.val));
                cur = cur.next;
            }
            cur = head;
            // 4. 构建新链表的 next 和 random 指向
            while(cur != null) {
                map.get(cur).next = map.get(cur.next);
                map.get(cur).random = map.get(cur.random);
                cur = cur.next;
            }
            // 5. 返回新链表的头节点
            return map.get(head);
        }



        public Node solu(Node head){
            if(head==null)return null;
            HashMap<Node,Node> map = new HashMap<>();
            Node temp = head;
            while(temp!=null){
                Node newNode = new Node(temp.val);
                map.put(temp,newNode);
                temp = temp.next;
            }
            temp = head;
            while(head!=null){
                Node node = map.get(head);
                node.next = map.get(head.next);
                if(head.random!=null)
                    node.random = map.get(head.random);
                else
                    node.random = null;
                head = head.next;
            }
            return map.get(temp);
        }

//参考题解
//    作者：jyd
//    链接：https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/solution/jian-zhi-offer-35-fu-za-lian-biao-de-fu-zhi-ha-xi-/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}