package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
핵심은 B -> A 로 가는 것
끝자리가 1이면 1을 삭제한다....
2로 나눠진다면 2로 나눈다...

무한루프 오류


 */

public class No16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int count = 1;

        while (A != B){
            if (B < A) {
                System.out.println(-1);
                System.exit(0);
            }
            if (B % 10 == 1) B /= 10;
            else if (B % 2 == 0) B /= 2;
            else {
                System.out.println(-1);
                System.exit(0);
            }
            count++;
        }

        System.out.println(count);
        br.close();
    }
}
