package second;

public class Medium_findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int target = nums.length - k;
        while(true){
            int i = quickSort(nums, left, right);
            if(i == target){
                return nums[i];
            }else if(i < target){
                left = i + 1;
            }else{
                right = i - 1;
            }
        }
    }

    private int quickSort(int[] nums,int left , int right){

        int sentry = nums[left];

        while(left < right){

            while(nums[right] > sentry && left<right)
                right--;
            if(left >= right)
                break;
            nums[left++] = nums[right];

            while(nums[left]<=sentry && left < right)
                left++;
            if(left >= right)
                break;
            nums[right] = nums[left];
        }
        nums[left] = sentry;

        return left;
    }
}
