package leetcode;

public class no695 {
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
	
	public static int maxAreaOfIsland(int[][] grid) {
        check = new boolean[grid.length + 1][grid[0].length + 1];
        int result = 0;
        
        for(int i = 0; i < grid.length; i++) {
        	for(int j = 0; j < grid[0].length; j++) {
        		if(grid[i][j] == 1 && check[i][j] == false) {
        			result = Math.max(result, dfs(grid, i, j));
        		}
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[][] A = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
		
		int result = maxAreaOfIsland(A);
		
		System.out.println(result);
	}

}
