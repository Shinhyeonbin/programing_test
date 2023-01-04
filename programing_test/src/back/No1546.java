package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] score = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            score[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(score);

        int M = score[n - 1];

        System.out.println(M);

        double sum = 0.0;
        for(int i = 0; i < score.length; i++) {
            sum += ((score[i] / score[score.length-1]) * 100);
        }

        System.out.println(sum / score.length);
    }


}
