package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No19947 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int s_money = Integer.parseInt(st.nextToken());
		int year = Integer.parseInt(st.nextToken());
		
		long[] memo = new long[year + 1];
		
		memo[0] = s_money;
		
		for(int i = 1; i < year + 1; i++) {
			memo[i] = (long)Math.floor(memo[i - 1] * 1.05);
			
			if(i > 4) {
				memo[i] = Math.max((long)Math.floor(memo[i - 3] * 1.2), memo[i]);
			}
			if(i > 6) {
				memo[i] = Math.max((long)Math.floor(memo[i - 5] * 1.35), memo[i]);
			}
		}
		
		System.out.println(memo[year]);
		
		br.close();
		
	}
}
