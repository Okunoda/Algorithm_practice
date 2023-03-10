import java.util.Arrays;

/**
 * @author Okunoda
 * @date 2023年03月09日13:52
 */
public class Day17_getLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        while(--k>=0){
            res[k] = arr[k];
        }
        return res;
    }
}
