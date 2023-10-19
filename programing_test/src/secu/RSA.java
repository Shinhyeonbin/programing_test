package secu;

import java.util.Scanner;

public class RSA {
	public static void main(String[] args) {
		int p, q, M;
		int e = 3;
		int d = 0;		
		
		
		Scanner sc = new Scanner(System.in);
		p = sc.nextInt();
		q = sc.nextInt();
		
		int N = p * q;
			
		while(d < 100) {
			if((3 * d) % ((p-1) * (q-1)) == 1) {
				break;
			}
			else {
				d++;
			}
		}
		
		M = sc.nextInt();
		
		sc.close();
		
		int C = (int)Math.pow(M, e) % N;
		
		System.out.println("개인키 " + d);
		System.out.println("암호문 " + C);
		
		System.out.println("복호화 "+ (long)Math.pow(C, d) % N);
		
	}

}
