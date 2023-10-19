package leetcode;

import java.util.ArrayList;

public class no997 {
	public static int findJudge(int n, int[][] trust) {
        
		/*
		ArrayList<ArrayList<Integer>> adjlist = new ArrayList<ArrayList<Integer>>();
		
        for(int i = 0; i < n; i++) {
        	adjlist.add(new ArrayList<Integer>());
        }
        
        for(int[] A : trust) {
        	adjlist.get(A[0]).add(A[1]);
        	check[A[1]]++;
        }
        */
		
		int[] check = new int[n + 1];
		
		if(n == 1) {
			return 1;
		}
        
        for(int i = 0; i < trust.length; i++) {
        	int out = trust[i][0];
        	int in = trust[i][1];
        	
        	check[out]--;
        	check[in]++;
        }
        
        for(int i = 0; i < n + 1; i++) {
        	if(check[i] == n - 1) {
        		return i;
        	}
        }
        return -1;
    }
	
	public static void main(String[] args) {
		
		int[][] A = {{1,2}, {3,2}, {4,2}, {5,2}, {6,2}};
		//int[][] A = {{1, 2}};
		
		
		int result = findJudge(6, A);

		System.out.println(result);
	}
	
}