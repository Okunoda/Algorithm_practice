package okunoda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author Erywim 2024/9/2
 */
public class Medium_spiralOrder {

    public static void main(String[] args) {
        int[][] test = {{1,2,3},{4,5,6},{7,8,9}};
        new Medium_spiralOrder().spiralOrder(test);
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return Collections.emptyList();
        }
        ArrayList<Integer> result = new ArrayList<>();
        int l = 0,r = matrix[0].length-1,t=0,b=matrix.length-1;

        while(true){
            //从左往右
            for (int i = l; i <= r; i++) {
                result.add(matrix[t][i]);
            }
            if(++t>b){
               break;
            }
            //从上往下
            for (int i = t; i <= b; i++) {
                result.add(matrix[i][r]);
            }
            if(--r<l){
                break;
            }
            for(int i = r; i >=l;i--){
                result.add(matrix[b][i]);
            }
            if(--b<t){
                break;
            }
            for(int i = b; i>=t;i--){
                result.add(matrix[i][l]);
            }
            if(++l>r){
                break;
            }
        }
        return result;
    }
}
