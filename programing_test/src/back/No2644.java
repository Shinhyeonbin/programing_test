package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No2644 {
	
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	
	static int result = -1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int family = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < family + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		visited = new boolean[family + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int edge = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			graph.get(s).add(e);
			graph.get(e).add(s);
		}
		
		dfs(x, y, 0);
		
		System.out.println(result);
		
	}
	
	private static void dfs(int s, int e, int depth) {
		if(s == e) {
			result = depth;
		}
		
		visited[s] = true;
		
		for(int i : graph.get(s)) {
			if(!visited[i]) {
				dfs(i, e, depth + 1);
			}
		}
	}
}
