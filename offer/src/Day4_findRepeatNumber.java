/**
 * @author Okunoda
 * @date 2023年02月24日16:40
 */
public class Day4_findRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        int[] point = new int[nums.length];
        for(int i : nums){
            point[i]++;
            if(point[i]>1){
                return i;
            }
        }
        return -1;
    }
}
