/**
 * @author Okunoda
 * @date 2023年02月28日8:47
 */
public class Day10_translateNum {
    public int translateNum(int num) {
        int temp = num;
        int count = 0;
        while(temp!=0){
            count++;
            temp/=10;
        }
        int[] nums = new int[count];
        for ( int i = count -1  ; i >= 0 ; i-- ){
            nums[ i ] = num%10;
            num /= 10;
        }

        int[] dp = new int[count];
        dp[0]=1;
        if(nums[0]*10+nums[1]<26){
            dp[1] = 2;
        }else{
            dp[1] = 1;
        }
        for(int i = 2 ; i < count ; i++ ){
            int i1 = nums[i - 1] * 10 + nums[i];
            if(i1 <26 && i1 >=10){
                dp[i] = dp[i-2] + dp[i-1];
            }else
                dp[i] = dp[i-1];
        }
        return dp[count-1];
    }

    public static void main(String[] args) {
        System.out.println(new Day10_translateNum().translateNum(1727101694));
    }
}
