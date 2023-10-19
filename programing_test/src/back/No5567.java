package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No5567 {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < n + 1; i++)
			graph.add(new ArrayList<>());
		
		visited = new boolean[n + 1];
		visited[1] = true;
		
		StringTokenizer st;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			graph.get(s).add(e);
			graph.get(e).add(s);
		}
		
		dfs(1, 0);
		
		int count = 0;
		for(int i = 2; i < visited.length; i++) {
			if(visited[i] == true) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}
	
	private static void dfs(int A, int dep) {
		if(dep == 2) {
			return;
		}
		for(int i : graph.get(A)) {
			visited[i] = true;
			dfs(i, dep + 1);
		}
	}
}
