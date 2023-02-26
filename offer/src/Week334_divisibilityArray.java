/**
 * @author Okunoda
 * @date 2023年02月26日10:44
 */
public class Week334_divisibilityArray {

    public static int[] divisibilityArray(String word, int m) {
        if(m==0) return new int[0];
        char[] nums = word.toCharArray();
        long current = 0l;
        int[] div = new int[nums.length];
        for(int i = 0 ; i<nums.length;i++){
            current = current*10+(nums[i]-'0');
            //缺少这一句，结果没过
            current%=m;
            if(current%m==0){
                current = 0;
                div[i] = 1;
            }
        }
        return div;
    }

    public static void main(String[] args) {
        int[] ints = divisibilityArray("91221181269244172125025075166510211202115152121212341281327", 21);
        for(int i : ints){
            System.out.print(i);
        }
    }
}
