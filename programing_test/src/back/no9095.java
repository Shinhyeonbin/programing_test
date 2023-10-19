package back;

import java.util.Scanner;

public class no9095 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int temp = sc.nextInt();
		int t = 0;
		while(t != temp) {
			int input = sc.nextInt();

			int[] A = new int[12];
			
			A[0] = 1;
			A[1] = 2;
			A[2] = 4;
			
			for(int i = 3; i < input; i++) {
				A[i] = A[i-1] + A[i-2] + A[i-3];
			}
			

			System.out.println(A[input - 1]);
			t++;
			
		}
		
		sc.close();
		
	}

}
