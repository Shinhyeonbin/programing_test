package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1100 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] board = new char[8][8];

        for(int i = 0; i < 8; i++){
            String input = br.readLine();
            for(int j = 0; j < 8; j++){
                board[i][j] = input.charAt(j);
            }
        }

        br.close();

        int count = 0;

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                // (i+j)가 짝수인 경우 (하얀색 칸을 의미)와 board[i][j]가 'F'인 경우 (말이 있는 칸을 의미) 모두 만족하는 경우를 찾는다.
                if((i + j) % 2 == 0 && board[i][j] == 'F'){
                    count++;
                }
            }
        }

        System.out.println(count);

    }
}
