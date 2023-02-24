/**
 * @author Okunoda
 * @date 2023年02月24日20:10
 */
public class Day4_missingNumber {
    public int missingNumber(int[] nums) {
        for(int i = 0; i<nums.length;i++){
            if(i!=nums[i])
                return i;
        }
        return nums.length;
    }
}
