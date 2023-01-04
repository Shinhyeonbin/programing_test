package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No4811 {
    static long[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 1000; i++){
            int med = Integer.parseInt(br.readLine());

            if(med == 0){
                break;
            }
            System.out.println(help(med));
        }
        br.close();
    }
    private static long help(int n) {
        memo = new long[n + 1];

        memo[0] = memo[1] = 1;

        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                memo[i] += memo[j-1] * memo[i-j];
            }
        }
        return memo[n];
    }
}
