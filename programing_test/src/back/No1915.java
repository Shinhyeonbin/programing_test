package back;

import java.util.Scanner;

public class No1915 {
	public static int Solution() {
		Scanner sc = new Scanner(System.in);
		
		int row = sc.nextInt();
		int col = sc.nextInt();
		
		int[][] arr = new int[row+ 1][col + 1];
		int[][] memo = new int[row + 1][col + 1];
		
		for(int i = 0; i < row; i++) {
			String line = sc.next();
			char[] A = line.toCharArray();
			for(int j = 0; j < col; j++) {
				arr[i][j] = A[j] - 48;	
			}
		}
		//input
		

		sc.close();
		
		int line = 0;
		for(int i = 0; i < row + 1; i++) {
			for(int j = 0; j < col + 1; j++) {
				memo[i][j] = arr[i][j];
				if(i >= 1 && j >= 1) {
					if(memo[i-1][j] > 0 && memo[i][j-1] > 0 && memo[i - 1][j - 1] > 0 && arr[i][j] > 0) {
						int min = Math.min(memo[i-1][j], Math.min(memo[i-1][j-1], memo[i][j-1]));
						memo[i][j] = min + 1;
					}
				}
				line = Math.max(line, memo[i][j]);
			}
		}
		
		return line * line;
	}

	public static void main(String[] args) {
		int A = Solution();
		System.out.println(A);
	}
}
