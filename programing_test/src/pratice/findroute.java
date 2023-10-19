package pratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class findroute {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static Stack<Integer> stack = new Stack<Integer>();
	static int n;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cities = Integer.parseInt(st.nextToken());
		int road = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < cities; i++) {
			graph.add(new ArrayList<>());
		}
		
		visited = new boolean[cities];
		
		for(int i = 0; i < road; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			graph.get(s).add(e);
		}
		
		dfs(0, 9);
		
	}
	
	private static void dfs(int s, int e) {
		visited[s] = true;
		stack.push(s);
		
		if(s == e) {
			for(int i = 0; i < stack.size(); i++) {
				System.out.printf("%d ", stack.elementAt(i));
			}
			stack.pop();
			return;
		}
		
		for(int i : graph.get(s)) {
			if(!visited[i]) {
				dfs(i, e);
			}
		}
		
		stack.pop();
		
	}
}
