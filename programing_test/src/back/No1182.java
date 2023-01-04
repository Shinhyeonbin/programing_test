package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Error 1 : StackOverFlow => 재귀함수 구현에서 빠져나오지 못한 것
Error 2 : 시간초과 -> 재귀접근은 휼륭하였으나, 백트레킹이 원할하게 이뤄지지 않음
Error 3 : 예제 투입시 2의 결과가 나옴 -> S가 0일때, 공집합의 경우 생각하지 않음


 */

public class No1182 {
    static int[] arr;
    static int N;
    static int S;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        backTracking(0, 0);

        if(S == 0) {
            System.out.println(count - 1);
        }
        else{
            System.out.println(count);
        }
    }
    private static void backTracking(int depth, int sum) {
        if(depth == N){
            if(sum == S){
                count++;
            }
            return;
        }
        backTracking(depth+1, sum + arr[depth]);
        backTracking(depth+1, sum);
    }
}
