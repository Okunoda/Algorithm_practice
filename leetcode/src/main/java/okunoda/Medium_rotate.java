package okunoda;

/**
 * @author Erywim 2024/7/11
 */
public class Medium_rotate {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int length = nums.length;
        transpose(nums, length - k, length - 1);
        transpose(nums,0,length - k -1);
        transpose(nums,0,length - 1);
    }

    private void transpose(int[] nums , int left ,int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
