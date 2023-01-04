package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/*
상근이가 숫자 5를 볼 때, 5로 볼 때도 있지만, 6으로 잘못 볼 수도 있고, 6을 볼 때는, 6으로 볼 때도 있지만, 5로 잘못 볼 수도 있다.

최대의 값을 생각해볼때.... -> 최대의 값은 둘다 6일경우 최대의 값이 나올 것이고
최소의 값을 생각하면.... -> 최소의 값은 둘다 5일경우 최소의 값이 나온다..

코드가 긴데... > replace를 써서 해결해보자

 */

public class No2864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());


        int[] a = Stream.of(String.valueOf(A).split("")).mapToInt(Integer::parseInt).toArray();
        int[] b = Stream.of(String.valueOf(B).split("")).mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i < a.length; i++){
            if(a[i] == 6){
                a[i] = 5;
            }
        }
        for(int i = 0; i < b.length; i++){
            if(b[i] == 6){
                b[i] = 5;
            }
        }

        int maxA = 0;
        for(int digit: a) { maxA *= 10; maxA += digit; }

        int maxB = 0;
        for(int digit: b) { maxB *= 10; maxB += digit; }

        for(int i = 0; i < a.length; i++){
            if(a[i] == 5){
                a[i] = 6;
            }
        }
        for(int i = 0; i < b.length; i++){
            if(b[i] == 5){
                b[i] = 6;
            }
        }

        int minA = 0;
        for(int digit: a) { minA *= 10; minA += digit; }

        int minB = 0;
        for(int digit: b) { minB *= 10; minB += digit; }

        System.out.printf("%d %d",  maxA + maxB, minA + minB);
        br.close();

    }
}
