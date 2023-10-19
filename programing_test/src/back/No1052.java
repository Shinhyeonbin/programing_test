package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1052 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int count = 0;
        while(true) {
            int tempN = N;
            int bottle = 0;

            // 물병을 2의 배수로 합치는 과정을 계산
            while(tempN > 0) {
                if(tempN % 2 == 1) {
                    bottle++;
                }
                tempN /= 2;
            }

            // 만약 합친 물병의 수가 K 이하라면 종료
            if(bottle <= K) {
                break;
            }

            // 그렇지 않으면 새로운 물병을 사고 N 증가
            N++;
            count++;
        }

        System.out.println(count);
    }
}
