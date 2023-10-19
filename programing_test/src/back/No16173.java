package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No16173 {
	
	static int[][] A;
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		
		A = new int[size][size];
		visited = new boolean[size][size];
		
		StringTokenizer st;
		
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < size; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean result = dfs(0, 0);
		
		if(result) {
			System.out.println("HaruHaru");
		}
		else {
			System.out.println("Hing");
		}
	}
	
	private static boolean dfs(int i, int j) {
		if(A.length - 1< i || A.length - 1 < j || visited[i][j] == true) {
			return false;
		}
		
		if(A.length -1 == i && A.length - 1 == j) {
			return true;
		}
		
		visited[i][j] = true;
		
		return dfs(i + A[i][j], j) || dfs(i, j + A[i][j]);		
	}
}

/* 
 * 방문한 지점 표시해야함 -> 시간초과 오류 발생
 * dfs이용 풀이
 * 
 */
