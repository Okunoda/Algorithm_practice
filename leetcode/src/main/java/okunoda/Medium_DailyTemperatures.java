package okunoda;

import java.util.HashMap;

/**
 * @author Okunoda 2024/3/29
 */
public class Medium_DailyTemperatures {
    public static void main(String[] args) {
        Medium_DailyTemperatures mm = new Medium_DailyTemperatures();
        mm.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        int[] stack = new int[length];
        int[] stackNum = new int[length];
        int sp = -1;
        for (int i = 0; i < length; i++) {
            int curInt = temperatures[i];
            if(sp > -1){
                if(stack[sp] < curInt){//如果当前值大于栈顶值，那么就进行出栈操作直到到栈底或大于当前值的
                    while(sp > -1 && stack[sp] < curInt){
                        int index = stackNum[sp--];
                        result[index] = i - index;
                    }
                }
            }
            stack[++sp] = curInt;
            stackNum[sp] = i;
        }
        while(sp > -1){
            int index = stackNum[sp--];
            result[index] = 0;
        }
        return result;
    }
}
