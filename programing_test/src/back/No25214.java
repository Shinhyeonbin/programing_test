package back;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No25214 {
	static int[] memo;
	static int[] A;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int size = Integer.parseInt(br.readLine());
		
		memo = new int[size];
		A = new int[size];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < size; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		
		memo[0] = 0;
		int min = A[0];
		int max = 0;
		
		for(int i = 1; i < size; i++) {
			max = Math.max(max, A[i] - min);
			memo[i] = max;
			if(A[i] < min) {
				min = A[i];
			}
			
		}	
		for(int i : memo) {
			bw.write(i + " ");
		}
		
		br.close();
		bw.close();
	}

}
