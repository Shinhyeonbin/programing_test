package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2748 {
	static long[] A;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		br.close();
		
		A = new long[input + 1];
		
		for(int i = 0; i < input + 1; i++) {
			A[i] = -1;
		}
		
		A[0] = 0;
		A[1] = 1;
		
		System.out.println(fib(input));
	}
	
	private static long fib(int N) {
		if(A[N] == -1) {
			A[N] = fib(N - 1) + fib(N - 2);
		}
		
		return A[N];
	}
	
	/*
	 * public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		br.close();
		
		long[] A = new long[input + 1];
		
		if(input < 2) {
			System.out.println(input);
		}
		else {
			A[0] = 0;
			A[1] = 1;
			
			for(int i = 2; i < input + 1; i++) {
				A[i] = A[i-1] + A[i-2];
			}
			
			System.out.println(A[input]);
		}
	}
	 */
}
