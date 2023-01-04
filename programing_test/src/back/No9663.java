package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
퀸을 놓을 수 있는 자리
퀸을 놓는 것을 일차원 배열로 생각할 수 있다.
 */

public class No9663 {
    static int[] arr;
    static int count = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        br.close();

        arr = new int[N + 1];

        nQueen(0);

        System.out.println(count);
    }

    public static void nQueen(int depth) {
        if(depth == N) {
            count++;
        }

        for(int i = 0; i < N; i++){
            arr[depth] = i;
            if(Possibility(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    private static boolean Possibility(int col) {
        for(int i = 0; i < col; i++) {
            if(arr[col] == arr[i]) {
                return false;
            }
            else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
