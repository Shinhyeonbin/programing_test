package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        n /= 100;
        n *= 100;
        int f = Integer.parseInt(br.readLine());

        int ans = 0;

        br.close();

        while (n % f != 0){
            n++;
            ans++;
        }

        if(ans < 10){
            System.out.println("0" + ans);
        }
        else{
            System.out.println(ans);
        }
    }
}
