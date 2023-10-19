package leetcode;

/*
 * 문제 : 건물의 높이가 주워지고,어느쪽에서 보는지에 따라 건물의 최대높이의 합을 달라질것이다.
 * 
 * -> 위쪽과 아래쪽, 원쪽과 오쪽으로 바라본 건물의 높이는 같을것이다. -> 사유 : 위치가 반전되고 합을 동일할것이기 때문이다. 
 * 
 * 그러면 조사해야할할 것은 2개 -> 위쪽과 왼쪽위치의 높이만 비교하면 된다. 
 * 
 * 위쪽으로 볼수있는 skyline을 해치지 않은선에서의 최대의 배열과 아래쪽으로 보이는 최대의 배열을 준비하여 원래의 값을 빼면 된다. 
 * 그리고 그 값을 합으로 넣으면 완성
 * 
 * 
 */

public class no897 {
	public static int maxIncreaseKeepingSkyline(int[][] grid) {
		int answer = 0;
		
		int size = grid.length;
		
		int[] frontMax = new int[size];
		int[] leftMax = new int[size];
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				frontMax[i] = Math.max(frontMax[i], grid[i][j]);
				leftMax[j] = Math.max(leftMax[j], grid[i][j]);
			}
		}
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				answer += Math.min(frontMax[i], leftMax[j]) - grid[i][j];
			}
		}
		
		return answer;
    }

	
	public static void main(String[] args) {
		int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
		
		System.out.println(maxIncreaseKeepingSkyline(grid));
	
	
	}
}
