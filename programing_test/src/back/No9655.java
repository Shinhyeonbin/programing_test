package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9655 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		
		br.close();
		
		if(input == 1) {
			System.out.println("SK");
		}
		else if(input == 2) {
			System.out.println("CY");
		}
		else if(input == 3) {
			System.out.println("SK");
		}
		else {
			int[] memo = new int[input + 1];
			memo[1] = 1;
			memo[2] = 2;
			memo[3] = 1;
			
			for(int i = 4; i < input + 1; i++) {
				memo[i] = Math.min(memo[i-1], memo[i-3]) + 1;
			}
			
			if(memo[input] % 2 == 0) {
				System.out.println("CY");
			}
			else {
				System.out.println("SK");
			}
		}
	}
}
