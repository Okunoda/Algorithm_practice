/**
 * @author Okunoda
 * @date 2023年02月26日10:35
 */
public class Week334_leftRigthDifference {
    public int[] leftRigthDifference(int[] nums) {
        int sumR = 0;
        for(int item : nums){
            sumR+=item;
        }
        int sumL = 0;
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] answer = new int[nums.length];
        for(int i = 0 ; i<nums.length;i++){
            left[i] = sumL;
            sumL += nums[i];
            sumR-=nums[i];
            right[i]=sumR;
            answer[i] = Math.abs(left[i]-right[i]);
        }
        return answer;
    }
}
