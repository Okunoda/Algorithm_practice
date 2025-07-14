package second;

import java.util.HashSet;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Easy_findRepeatDocument {
    public int findRepeatDocument(int[] documents) {


        /*
        方式一：快速排序后找到重复元素，有几个测试样例超时过不去
         */
        //先快速排序，然后遍历找重复元素
        quickSort(documents, 0, documents.length - 1);
        for(int i = 0 ; i < documents.length-1 ; i++){
            int current = documents[i];
            if( current == documents[i+1]){
                return current;
            }
        }



        /*
        方式二：哈希表
         */
        HashSet<Integer> set = new HashSet<>();
        for(int current:documents){
            if(set.contains(current)){
                return current;
            }else{
                set.add(current);
            }
        }


        return -1;

    }


    private void quickSort(int[] nums , int start , int end){
        if(start >= end)
            return;

        int base = nums[start];
        int left = start ;
        int right = end;
        while(left < right){
            //从end开始找，找到比哨兵小的节点，即为right
            while(left < right && nums[right] >= base){
                right--;
            }
            //从start开始找，找到比哨兵大的节点，即为left
            nums[left] = nums[right];

            while(left < right && nums[left] <= base){
                left++;
            }

            nums[right] = nums[left];
        }
        nums[left] = base;
        quickSort(nums,start,left-1);
        quickSort(nums,left+1,end);

    }
}
