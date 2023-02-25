import java.util.Iterator;
import java.util.Stack;

/**
 * @author Okunoda
 * @date 2023年02月23日22:42
 */

class Day1_MinStack {

    /** initialize your data structure here. */
    int min  = Integer.MAX_VALUE;
    Stack<Integer> stack ;
    public Day1_MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(x < min){
            min = x;
        }
    }

    public void pop() {
        int temp = stack.pop();
        if(temp == min){
            min = Integer.MAX_VALUE;
            Iterator<Integer> iterator = stack.iterator();
            while(iterator.hasNext()){
                int item = iterator.next();
                if(item<min){
                    min = item;
                }
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }
}
