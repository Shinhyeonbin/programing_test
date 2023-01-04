package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = N; i > 0; i--){
            for(int j = i; j <= N; j++){
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}
