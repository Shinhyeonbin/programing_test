package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2839 {
	static int[] memo;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int suger = Integer.parseInt(br.readLine());
		
		memo = new int[suger + 1];
		
		if(suger >= 3) {
			memo[3] = 1;
		}
		if(suger >= 5) {
			memo[5] = 1;
		}
		
		for(int i = 6; i <= suger; i++) {
			if(i % 3 == 0) {
				memo[i] = memo[i -3] + 1;
			}
			else if(i % 5 == 0) {
				memo[i] = memo[i-5] + 1;
			}
			else {
				if(memo[i-3] != 0 && memo[i-5] != 0) {
					memo[i] = 1 + Math.min(memo[i - 3], memo[i - 5]);
				}
			}
		}
		
		if(memo[suger] == 0) {
			System.out.println("-1");
		}
		else {
			System.out.println(memo[suger]);
		}
	}
}
