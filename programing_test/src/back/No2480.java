package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dice = new int[6];
        int result = 0;


        for(int i = 0; i < 3; i++){
            int input = Integer.parseInt(st.nextToken());
            dice[input- 1]++;
        }
        //입력

        for(int i = 0; i < 6; i++){
            if(dice[i] == 3){
                result = 10000 + (i + 1) * 1000;
                break;
            }
            else if(dice[i] == 2){
                result = 1000 + (i + 1) * 100;
                break;
            }
            else if(dice[i] == 1){
                result = (i + 1) * 100;
            }
        }
        System.out.println(result);
    }
}
