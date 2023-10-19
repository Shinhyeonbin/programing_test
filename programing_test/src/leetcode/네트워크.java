package leetcode;

public class 네트워크 {
	public static int solution(int n, int[][] computers) {
		int answer = 0;
		
		boolean[] check = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			if(!check[i]) {
				dfs(computers, i, check);
				answer++;
			}
		}
		return answer;
	}
	
	private static boolean[] dfs(int[][] computers, int n, boolean[] check) {
		check[n] = true;
		
		for(int i = 0; i < computers.length; i++) {
			if(i != n && computers[n][i] == 1 && check[i] == false)
				check = dfs(computers, i, check);
		}
		return check;
	}
	
	public static void main(String[] args) {
		
	}

}
