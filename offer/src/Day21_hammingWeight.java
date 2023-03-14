/**
 * @author Okunoda
 * @date 2023年03月13日23:51
 */
public class Day21_hammingWeight {
    public int hammingWeight(int n) {
        int count = 0;
        int bit = 1;
        for (int i = 0; i < 32; i++) {
            if((n & bit) == bit)
                count++;
            bit = bit<<1;
        }
        return count;
    }
}
