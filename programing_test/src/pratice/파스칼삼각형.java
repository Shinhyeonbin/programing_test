package pratice;

import java.util.Scanner;

public class 파스칼삼각형 {
	static int[][] A;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int temp = sc.nextInt();
		
		int t = 0;
		
		while(t != temp) {
			int input = sc.nextInt();
			A = new int[input + 1][input + 1];
			
			for(int i = 0; i < input + 1; i++) {
				A[i][0] = 1;
			}
			
			for(int i = 1; i < input + 1; i++) {
				for(int j = 1; j < input + 1; j++) {
					A[i][j] = A[i-1][j -1] + A[i - 1][j];
				}
			}

			for(int i = 0; i < input; i++) {
				System.out.printf("%d ", A[input - 1][i]);
				System.out.println();
			}
			
			t++;
		}

		sc.close();
		
	}
	
}
