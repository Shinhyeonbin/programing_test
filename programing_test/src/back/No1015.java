package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1015 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
            B[i] = A[i];
        }
        Arrays.sort(B);

        boolean checked[] = new boolean[N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(B[i] == A[j] && !checked[j]){
                    C[j] = i;
                    checked[j] = true;
                    break;
                }
            }
        }

        for(int i = 0; i < N; i++){
            System.out.print(C[i] + " ");
        }
    }
}
