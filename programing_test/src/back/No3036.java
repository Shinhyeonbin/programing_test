package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No3036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] result = new int[size - 1][2];

        int value;

        //공약수를 찾아야함 -> 공약수를 찾는 방법을 떠올려봐 숫자 2개가 들어가고 1 ~ 1000으로 이동해서 둘다 나눠지면 되는거 아님?
        for(int i = 1; i < size; i++){
            value = find_key(arr[0], arr[i]);
            result[i - 1][0] = arr[0] / value;
            result[i - 1][1] = arr[i] / value;
        }

        for(int i = 0; i < result.length; i++){
            System.out.printf("%d/%d\n", result[i][0], result[i][1]);
        }
    }

    static int find_key (int num1, int num2){
        int num_key = 0;

        if(num1 > num2){
            for(int i = 1; i <= num2; i++){
                if(num1 % i == 0 && num2 % i == 0){
                    num_key = i;
                }
            }
        }
        else{
            for(int i = 1; i <= num1; i++){
                if(num1 % i == 0 && num2 % i == 0){
                    num_key = i;
                }
            }
        }

        return num_key;
    }
}
