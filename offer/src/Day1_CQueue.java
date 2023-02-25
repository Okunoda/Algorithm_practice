/**
 * @author Okunoda
 * @date 2023年02月23日22:29
 */

class Day1_CQueue {

    int tail;
    int head;
    int[] nums;
    public Day1_CQueue() {
        nums = new int[10000];
        tail = 0;
        head = 0;
    }

    public void appendTail(int value) {
        if(isFull())return;
        nums[tail] = value;
        tail = (tail+1)%10000;

    }

    public int deleteHead() {
        if(tail==head) return -1;
        int res = nums[head];
        head = (head+1)%10000;
        return res;

    }

    private boolean isFull(){
        return tail + 1 == head;
    }
}


