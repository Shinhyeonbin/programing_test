package back;

import java.util.Scanner;

public class No2775 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int temp = sc.nextInt();
		int t= 0;
		
		while(t != temp) {
			
			int k = sc.nextInt();
			int n = sc.nextInt();
			
			int[][] A = new int[k + 1][n+ 1];
			
			for(int i = 1; i < n + 1; i++) {
				A[0][i] = i;
			}
			
			for (int i = 1; i < k + 1; i++) {
			      for (int j = 1; j < n + 1; j++) {
			        A[i][j] = A[i-1][j] + A[i][j-1];
			      }
			    }
			System.out.println(A[k][n]);
			t++;
		}
		sc.close();
	}
}
