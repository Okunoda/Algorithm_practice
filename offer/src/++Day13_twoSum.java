/**
 * @author Okunoda
 * @date 2023年03月02日11:08
 */
 class Day13_twoSum {
    //目前能想到的最优解是第一个指针按顺序走，然后在右侧的子数组中使用折半查找，查target-nums[i]的数
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0 ; i < nums.length ; i++){
            int other = target - nums[i];
            if(binarySearch(nums,i+1,nums.length-1,other)){
                return new int[]{nums[i],other};
            }
        }
        return new int[0];
    }
    private boolean binarySearch(int[] nums,int left , int right , int target){
        int mid = (left + right) / 2;
        while(left <= right){
            if(nums[mid] == target){
                return true;
            }
            else if(nums[mid] > target){
                right = mid -1;

            }else{
                left = mid +1;
            }
            mid = (right+left)/2;
        }
        return false;
    }



//    作者：jyd
//    链接：https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/solution/mian-shi-ti-57-he-wei-s-de-liang-ge-shu-zi-shuang-/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //这个方法显然更好，时间复杂度降到了o(n)，多了减一点，少了加一点
        public int[] twoSum2(int[] nums, int target) {
            int i = 0, j = nums.length - 1;
            while(i < j) {
                int s = nums[i] + nums[j];
                if(s < target) i++;
                else if(s > target) j--;
                else return new int[] { nums[i], nums[j] };
            }
            return new int[0];
        }


}
