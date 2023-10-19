package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No17202 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String A = in.readLine();
		String B = in.readLine();
		String C = "";
		
		for(int i = 0; i < A.length(); i++) {
			C += A.charAt(i);
			C += B.charAt(i);
		}
		
		while(C.length() > 2) {
			String D = "";
			for(int i = 0; i< C.length()-1; i++){
				int n = Character.getNumericValue(C.charAt(i)) + Character.getNumericValue(C.charAt(i + 1));
				
				D += Integer.toString(n % 10);
			}
			C = D;
		}
		
		System.out.println(C);
	}
}
