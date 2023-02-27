
/**
 * @author Okunoda
 * @date 2023年02月26日23:36
 */
public class Day8_fib {
    public int fib(int n) {
        int[] pp = new int[101];
        pp[0]= 0;
        pp[1] = 1;
        for(int i = 2;i<101;i++){
            pp[i] = (pp[i-1]+pp[i-2])%1000000007;
        }
        return pp[n];
    }

}
