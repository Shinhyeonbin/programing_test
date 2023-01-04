package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
정렬하고 첫번째 값 * ropes 을 하면 될것이다 -> wrong

문제 이해 부족 -> 줄이 증가한다... -> 다르다.



 */

public class No2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rope = Integer.parseInt(br.readLine());

        int[] lift = new int[rope];

        for(int i = 0; i < rope; i++){
            lift[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lift);

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < rope; i++) {
            max = Math.max(max, lift[i] * (rope - i));
        }

        System.out.println(max);

        br.close();
    }

}
