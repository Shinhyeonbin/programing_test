package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No10872 {
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N < 3) {
            if(N == 0)
                System.out.println(1);
            else
                System.out.println(N);
        }
        else{
            memo = new int[N + 1];

            Arrays.fill(memo, -1);
            memo[0] = 1;
            memo[1] = 1;
            memo[2] = 2;

            System.out.println(re(N));

        }
    }
    private static int re(int N) {
        if(memo[N] != -1){
            return memo[N];
        }
        return N * re(N - 1);
    }
}
