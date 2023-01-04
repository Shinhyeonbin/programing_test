package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
정렬을 먼저한다테이프의 길이가 얼마나 필요한지 생각한다.


테이프의 범위가 필요하다.... => 범위 이내일 경우 하나의 테이프로 처리가 가능하다.

테이프의 범위를 초과하게 되면 새로운 테이프를 가져온다.
 */

public class No1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int tape = 0;

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int tapeRange = (int)(arr[0] - 0.5 + L);
        tape++;

        for(int i=1; i < arr.length; i++) {
            if (tapeRange < (int)(arr[i] + 0.5)){
                tapeRange = (int)(arr[i] - 0.5 + L);
                tape++;
            }
        }

        System.out.println(tape);
        br.close();
    }
}
