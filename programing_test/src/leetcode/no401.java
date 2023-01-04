package leetcode;

import java.util.ArrayList;
import java.util.List;

public class no401 {
    /* bitcount를 통한 풀이입니다.
    public static  List<String> readBinaryWatch(int num) {
        ArrayList<String> result = new ArrayList<>();

        for(int i = 0; i < 12; i++) {
            for(int j = 0; j < 60; j++){
                if(Integer.bitCount(i) + Integer.bitCount(j) == num){
                    if(j < 10){
                        result.add(String.format("%d:0%d", i, j));
                    }
                    else{
                        result.add(String.format("%d:%d", i, j));
                    }
                }
            }
        }
        return result;
    }
    */

    //backtracking을 이용한 풀이입니다.
    public static  List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();

        int[] arr = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
        backtrack(arr, 0, 0, 0, num, result);
        return result;
    }

    private static void backtrack(int[] arr, int pos, int hour, int min, int max, List<String> answer) {
        if(max == 0){
            if(hour <= 11 && min <= 59){
                StringBuilder sb = new StringBuilder();
                sb.append(hour).append(":").append(min <= 9 ? "0" + min : min);
                answer.add(sb.toString());
            }
            return;
        }

        for(int i = pos; i < arr.length; i++){
            if(isHour(i))
                hour += arr[i];
            else
                min += arr[i];

            backtrack(arr, i + 1, hour, min, max - 1, answer);

            if(isHour(i))
                hour -= arr[i];
            else
                min -= arr[i];
        }
    }

    private static boolean isHour(int n) {
        return n >= 0 && n <= 3;
    }

    public static void main(String[] agrs) {
        int turn = 8;

        System.out.println(readBinaryWatch(turn).size());

        for(String A : readBinaryWatch(turn)){
            System.out.println(A);
        }
    }
}
