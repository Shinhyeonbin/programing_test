package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백트레킹 연습문제 ----> 일단 코드로 작성하기 전에 트리형태로 도식화 해보자...

 */

public class No15649 {
    static int[] arr;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int N, M;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            br.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        arr = new int[M];
        check = new boolean[N];

        backtracking(N, M, 0);

        System.out.println(sb);

    }
    private static void backtracking(int N, int M, int depth) {
        if(depth == M){
            for(int A : arr){
                sb.append(A).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i = 0; i < N; i++){
            if(!check[i]){
                check[i] = true;
                arr[depth] = i + 1;
                backtracking(N, M, depth + 1);
                check[i] = false;
            }
        }
    }
}
