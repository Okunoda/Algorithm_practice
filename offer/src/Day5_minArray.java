/**
 * @author Okunoda
 * @date 2023年02月25日16:40
 */
public class Day5_minArray {
    public int minArray(int[] numbers) {
        for(int i = 0 ; i<numbers.length-1;i++){
            if(numbers[i]>numbers[i+1])
                return numbers[i+1];
        }
        return numbers[0];
    }
}
