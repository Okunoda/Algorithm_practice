package second;

public class Easy_countNumbers {
    public int[] countNumbers(int cnt) {
        StringBuffer sb = new StringBuffer();
        sb.append(1);
        while(cnt-->0){
            sb.append(0);
        }
        Integer i = Integer.parseInt(sb.toString()) - 1;
        int[] result = new int[i];
        for (int j = 1; j <= i; j++) {
            result[j-1] = j;
        }
        return result;
    }
}
