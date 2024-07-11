package okunoda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Erywim 2024/7/10
 */
public class Medium_merge {
    public static void main(String[] args) {
        Medium_merge mediumMerge = new Medium_merge();

        int[][] merge = mediumMerge.merge(new int[][]{{1, 4}, {0,2}});
//        int[][] merge = mediumMerge.merge(new int[][]{{0,3},{2,3},{4,5},{6,7},{8,9},{1,10}});
//        int[][] merge = mediumMerge.merge(new int[][]{{2,3},{1,6},{8,10},{15,18}});
//        int[][] merge = mediumMerge.merge(new int[][]{{2,3},{5,5},{2,2},{3,4},{3,4}});
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }
    }
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        if(intervals.length < 1) return intervals;
        int[] preArr = intervals[0];
        int currentLeft = preArr[0];
        int currentRight = preArr[1];
        for (int i = 1; i < intervals.length; i++) {
            int[] currentArr = intervals[i];
            if(!(currentRight < currentArr[0] || currentLeft > currentArr[1])){
                int left = Math.min(currentLeft, currentArr[0]);
                int right = Math.max(currentRight, currentArr[1]);

                currentLeft = left;
                currentRight = right;
            }else{
                result.add(new int[]{currentLeft, currentRight});
                currentLeft = currentArr[0];
                currentRight = currentArr[1];
            }
        }

        result.add(new int[]{currentLeft, currentRight});
        return result.toArray(new int[result.size()][]);
    }
}
