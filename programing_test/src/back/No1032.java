package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String arr[] = new String[50];

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = br.readLine();
            }

        br.close();

        if(N >= 2){
            StringBuilder sb = new StringBuilder();
            int length = arr[0].length();

            for(int i = 0; i < length; i++){
                char current = arr[0].charAt(i);
                boolean allSame = true;

                for(int j = 1; j < N; j++){
                    if(arr[j].charAt(i) != current){
                        allSame = false;
                    }
                }

                if(allSame){
                    sb.append(current);
                }
                else{
                    sb.append('?');
                }
            }

            System.out.println(sb.toString());
        }
        else{
            System.out.println(arr[0].toString());
        }
    }
}
