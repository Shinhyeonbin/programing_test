package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class no13301 {
	static long[] A;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(in.readLine());
		
		if(input == 0) {
			System.out.println(0);
		}
		else if(input == 1) {
			System.out.println(4);
		}
		else if(input == 2) {
			System.out.println(6);
		}
		else {
			A = new long[input + 1];
			
			Arrays.fill(A, -1);
			
			A[0] = 0;
			A[1] = 1;
			A[2] = 2;
			
			long A = help(input);
			long B = help(input - 1);
			
			System.out.println((A + B) * 2);
		}
		
	}
	private static long help(int n) {
		if(A[n] == -1) {
			A[n] = help(n-1) + help(n-2);
		}
		
		return A[n];
	}
}
