import java.util.Arrays;

/**
 * @author Okunoda
 * @date 2023年03月09日11:10
 */
public class Day16_isStraight {
    public boolean isStraight(int[] nums) {
        int miss = 0;
        Arrays.sort(nums);
        for(int i = 0; i < 4; i++) {
            if(nums[i] == 0)
                miss++;
            else if(nums[i] == nums[i + 1])
                return false;
        }
        return nums[4] - nums[miss] < 5;

    }
}
