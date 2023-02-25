/**
 * @author Okunoda
 * @date 2023年02月25日20:53
 */
public class Day5_findNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0)return false;
        for(int[] item:matrix){
            if(item[0]>target)
                continue;
            if(binarySearch(item,target)){
                return true;
            }
        }
        return false;
    }
    private boolean binarySearch(int[] arr,int target){
        int left = 0;
        int right = arr.length-1;
        int mid = (left+right)/2;
        while(left<=right){
            if(arr[mid]>target){
                right=mid-1;
            }else if(arr[mid]<target){
                left =mid+1;
            }else
                return true;
            mid = (left+right)/2;
        }
        return false;
    }
}
