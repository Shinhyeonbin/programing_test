package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 큰수만들기 {
	public static String solution(String number, int k) {
		StringBuilder sb = new StringBuilder();
        int index = 0;
        int next = 0;
        
        for (int i = 0; i < number.length() - k; i++) {
            int max = 0;
            
            for (int j = index; j <= i + k; j++) {
                int current = number.charAt(j) - '0';

                if (max < current) {
                    max = current;
                    next = j;
                }
            }
            sb.append(max);
            index = next + 1;
        }
        return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String number = br.readLine();
		int k = Integer.parseInt(br.readLine());
				
		System.out.println(solution(number, k));
	}
}
