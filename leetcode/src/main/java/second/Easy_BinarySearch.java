package second;

/**
 * @Date 2025/3/3
 */
public class Easy_BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(right > left){
            int mid = left + (right - left) / 2;
            int num = nums[mid];
            if(num == target){
                return mid;
            }else if(target > num){
                left = mid + 1;
            }else if(target < num){
                right = mid-1;
            }
        }
        return -1;
    }
}
