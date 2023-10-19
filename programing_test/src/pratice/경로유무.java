package pratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 경로유무 {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int vertex = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < vertex; i++) {
			graph.add(new ArrayList<>());
		}
		
		int t = 0;
		
		br.readLine();
		
		while(t != edge) {
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			graph.get(s).add(e);
			graph.get(e).add(s);	
			t++;
		}
		
		t = 0;
		int a = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		while(t != a) {
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			t++;
		}
		
		
	}

}
