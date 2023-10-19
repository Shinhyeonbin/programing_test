package pratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 징검다리 {
	static int[] memo;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int temp = Integer.parseInt(br.readLine());
		
		int t = 0;
		
		StringTokenizer st;
		while(t != temp) {
			st = new StringTokenizer(br.readLine());
			int input = Integer.parseInt(st.nextToken());
			int[] A = new int[input];
			memo = new int[input];
			
			for(int i = 0; i < input; i++) {
				int value = Integer.parseInt(st.nextToken());
				A[i] = value;
			}
			
			for(int i = 0; i < input; i++) {
				memo[i] = -1;
			}
			/*
			for(int i = 0; i < input; i++) {
				System.out.printf("%d ", A[i]);
			}
			*/
			
			memo[0] = A[0];
			memo[1] = A[1];
			
			System.out.println(Math.min(help(A, input - 1), help(A, input - 2)));
			
			
		}

		br.close();
	}
	private static int help(int[] A, int n) {
		if(memo[n] == -1) {
			int one = help(A, n-1);
			int two = help(A, n-2);
			
			memo[n] = A[n] + Math.min(one, two);
		}
		
		return memo[n];
		
	}
}
