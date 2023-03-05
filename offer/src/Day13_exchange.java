/**
 * @author Okunoda
 * @date 2023年03月02日10:22
 */
public class Day13_exchange {
    public int[] exchange(int[] nums) {
        int front = 0;
        int rear = nums.length-1;
        while(front < rear){
            while(front < rear && nums[front]%2==1)
                front++;
            while(front < rear && nums[rear]%2==0)
                rear--;
            int temp = nums[front];
            nums[front] = nums[rear];
            nums[rear] = temp;
        }
        return nums;
    }
}
