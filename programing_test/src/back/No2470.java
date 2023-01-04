package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
산성 용액만으로나 알칼리성 용액만으로 입력이 주어지는 경우 -> 이거 체크하면 완성됨...

5
2 32 1 42 14

5
-2 -32 -1 -42 -14
*/

public class No2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(arr);

        int i = 0;
        int j = arr.length - 1;

        int gap = Integer.MAX_VALUE;
        int num1 = 0;
        int num2 = 0;

        int temp;
        int sum;
        while (i < j) {
            sum = arr[i] + arr[j];
            temp = Math.abs(sum);
            if (temp < gap) {
                gap = temp;
                num1 = arr[i];
                num2 = arr[j];
            }
            if (sum > 0)
                j--;
            else
                i++;
        }

        System.out.println(num1 + " " + num2);

    }
}
