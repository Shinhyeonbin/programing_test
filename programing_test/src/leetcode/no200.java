package leetcode;

import java.util.Arrays;

public class no200 {
    static boolean[][] check;
	
	private static int dfs(int[][] A, int r, int c) {
		if(A.length - 1 < r || A[0].length - 1 < c  || r < 0 || c < 0 || A[r][c] == 0 || check[r][c] == true) {	//행의 길이보다 r이 크고 열의 길이보다 c 이 크고, c <0,  r< 0, 재방문 하면안됨 
			return 0;
		}
		
		check[r][c] = true;
	
		int up = dfs(A, r - 1, c);
		int down =  dfs(A, r + 1, c);
		int left = dfs(A, r, c - 1);
		int right = dfs(A, r, c + 1);
		
		return 1 + up + down + left + right;
	}
	
	public static int numIslands(int[][] grid) {
        check = new boolean[grid.length + 1][grid[0].length + 1];
        int count = 0;
        
        for(int i = 0; i < grid.length; i++) {
        	for(int j = 0; j < grid[0].length; j++) {
        		if(grid[i][j] == 1 && check[i][j] == false) {
        			if(dfs(grid, i, j) != 0) {
        				count++;
        			}
        		}
        	}
        }
        return count;
    }
	
	public static void main(String[] args) {
		//int[][] A = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
		String[][] B = {{"1","1","1","1","0"}, {"1","1","0","1","0"}, {"1","1","0","0","0"}, {"0","0","0","0","0"}};
		int[][] A = new int[B.length][B[0].length];
		
		for(int i = 0; i < B.length; i++) {
			for(int j = 0; j < B[0].length; j++) {
				A[i][j] = Integer.parseInt(B[i][j]);
			}
		}
		
		int result = numIslands(A);
		
		System.out.println(result);
	}

}
