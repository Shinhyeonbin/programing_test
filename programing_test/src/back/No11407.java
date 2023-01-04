package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
그리디 방안으로 생각... => 정렬해서 큰거먼저 제거하자

 */

public class No11407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int count = 0;

        Integer[] wallet = new Integer[N];

        for(int i = 0; i < N; i++){
            wallet[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(wallet, Collections.reverseOrder());

        int pos = 0;

        while(K != 0){
            if(K >= wallet[pos]){
                count += K / wallet[pos];
                K = K % wallet[pos];
            }
            else{
                pos++;
            }
        }

        System.out.println(count);
    }
}
