package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10026 {
	static char[][] A;
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());

		A = new char[size][size];
		visited = new boolean[size][size];
	
		for(int i = 0; i < size; i++) {
			char[] s = (br.readLine()).toCharArray();
			for(int j = 0;  j < size; j++) {
				A[i][j] = s[j];
			}
		}
		
		green(0, 0);
		
		
		
	}
	private static int green(int r, int c) {
		if(A.length < c || A.length < r || 0 > r || 0 > c|| visited[r][c] == false || A[r][c] != 'G') {
			return 0;
		}
		
		int up = green(r - 1, c);
		int down = green(r + 1, c);
		int left = green(r, c + 1);
		int right = green(r, c - 1);
		
		return 1 + up + down + left + right;
		
	}
}

