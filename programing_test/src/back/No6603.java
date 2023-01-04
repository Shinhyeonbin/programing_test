package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Error1 : 중복된값
중복된 값만 제거하면 되는데... => HashSet을 이용하면 되지 않을까? => 베열로 해결... => 출력방식의 잘못됨

*/

public class No6603 {
    static int[] S;
    static int[] result;
    static int k;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0) {
                break;
            }
            result = new int[k];
            S = new int[k];
            for(int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }
            Backtracking(0, 0);

            System.out.println();
        }// end of while

    }

    private static void Backtracking(int start, int depth) {
        if(depth == 6) {
            print();
        }
        for(int i = start; i < k; i++) {
            result[i] = 1;
            Backtracking(i+1, depth+1);
            result[i] = 0;
        }
    }

    private static void print() {
        for(int i =0; i < k; i++) {
            if(result[i] == 1) {
                System.out.print(S[i]+" ");
            }
        }
        System.out.println();
    }

}
