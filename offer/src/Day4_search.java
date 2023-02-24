/**
 * @author Okunoda
 * @date 2023年02月24日19:45
 */
//二分查找不是很熟练，提交的时候出现了一些小问题
public class Day4_search {
    public int search(int[] nums, int target) {
        if(nums.length==0)return 0;
        int left =0;
        int right = nums.length-1;
        int mid = (left+right)/2;
        int point=-1;
        int count=0;
        while(left<=right){
            if(nums[mid]>target){
                right = mid-1;
            }else if(nums[mid]<target){
                left = mid+1;
            }else{
                point = mid;
                break;
            }
            mid = (left+right)/2;
        }
        for(int i = point;i>=0;i--){
            if(nums[i]==target)
                count++;
        }
        while(++point<nums.length&&nums[point]==target)
            count++;
        return count;
    }

}
