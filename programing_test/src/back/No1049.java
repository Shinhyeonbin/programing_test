package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] packagePrice = new int[M];
        int[] individualPrice = new int[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            packagePrice[i] = Integer.parseInt(st.nextToken());
            individualPrice[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(packagePrice);
        Arrays.sort(individualPrice);

        int totalPrice = 0;
        if (individualPrice[0] * 6 <= packagePrice[0]) {
            totalPrice = individualPrice[0] * N;
        } else {
            totalPrice = (N / 6) * packagePrice[0] + Math.min((N % 6) * individualPrice[0], packagePrice[0]);
        }

        System.out.println(totalPrice);
    }
}
