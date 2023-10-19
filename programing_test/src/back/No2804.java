package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String[] splitStrings = input.split(" ");

        char[] firstCharArray = splitStrings[0].toCharArray();
        char[] secondCharArray = splitStrings[1].toCharArray();

        int pos1 = 0;
        int pos2 = 0;
        boolean stop = false;


        for(int i = 0; i < firstCharArray.length; i++){
            for(int j = 0; j < secondCharArray.length; j++){
                if(firstCharArray[i] == secondCharArray[j]){
                    pos1 = j;
                    stop = true;
                    break;
                }
            }
            if(stop){
                pos2 = i;
                break;
            }
        }


        char[][] printArray = new char[secondCharArray.length][firstCharArray.length];

        for(int i = 0; i < secondCharArray.length; i++){
            for(int j = 0; j < firstCharArray.length; j++) {
                printArray[i][j] = '.';
            }
        }

        for(int i = 0; i < firstCharArray.length; i++){
            printArray[pos1][i] = firstCharArray[i];
        }

        for(int i = 0; i < secondCharArray.length; i++){
            printArray[i][pos2] = secondCharArray[i];
        }

        for(int i = 0; i < secondCharArray.length; i++){
            for(int j = 0; j < firstCharArray.length; j++){
                System.out.print(printArray[i][j]);
            }
            System.out.println();
        }
    }
}
