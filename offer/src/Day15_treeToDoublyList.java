import java.util.ArrayList;
import java.util.List;

/**
 * @author Okunoda
 * @date 2023年03月09日10:20
 */
public class Day15_treeToDoublyList {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    public Node treeToDoublyList(Node root) {
        if(root==null) return null;
        inOrder(root);
        Node current = list.get(0);
        current.left = list.get(count-1);

        for(int i = 1 ; i<count;i++){
            Node temp = list.get(i);
            temp.left = current;
            current.right = temp;
            current = temp;
        }
        list.get(count-1).right = list.get(0);

        return list.get(0);

    }
    List<Node> list = new ArrayList<>();
    int count =0;

    void inOrder(Node root ){
        if(root==null)
            return ;
        inOrder(root.left);
        list.add(root);
        count++;
        inOrder(root.right);
    }
}
