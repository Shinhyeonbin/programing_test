package pratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class count0 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int time = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < time; i++) {
			String A = br.readLine();
			
			char[] B = A.toCharArray();
			
			System.out.println(help(B, B.length - 1, 0));
		}
	}
	
	private static int help(char[] number, int i, int count) {
		if(i == -1) {
			return count;
		}
		
		if(number[i] == '1') {
			count++;
		}
		
		return help(number, i - 1, count);
	}
}
