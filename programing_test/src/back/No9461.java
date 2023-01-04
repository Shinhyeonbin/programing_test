package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i< T; i++){
            int N = Integer.parseInt(br.readLine());
            int result = re(N);

            System.out.println(result);
        }
    }

    private static int re(int n) {
        if(n == 1){
            return 1;
        }
        int prev = re(n - 1);

        return prev + (n % 2 == 0 ? 1 : -1);
    }
}
