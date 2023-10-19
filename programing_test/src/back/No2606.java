package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2606 {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] vistied;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int com = Integer.parseInt(br.readLine());
		int temp = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < com + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		vistied = new boolean[com + 2];
		
		Arrays.fill(vistied, false);
		
		int t = 0;
		
		StringTokenizer st;
		while(t != temp) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			graph.get(start).add(end);
			graph.get(end).add(start);
		
			t++;	
		}
		br.close();
		
		dfs(1);
		int count = 0;
		for(int i = 2; i < vistied.length; i++) {
			if(vistied[i] == true) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	private static void dfs(int n) {
		if(vistied[n] == true) {
			return;
		}
		for(int i : graph.get(n)) {
			vistied[n] = true;
			dfs(i);
		}
	}
}
