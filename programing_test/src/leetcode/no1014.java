package leetcode;

public class no1014 {
	public static int maxScoreSightseeingPair(int[] values) {
		
		
		//처음생각한 코드 -> 시간 O(n^2) DP풀이 X
		/*
		int max = 0;
		for(int i = 0; i < values.length; i++) {
			for(int j = i + 1; j < values.length; j++) {
				int next = values[i] + values[j] + i - j;
				max = Math.max(next, max);
			}
		}
		*/
		
		
		//DP 풀
		int max = values[0];
		
		int current = 0;
		for(int i = 1; i < values.length; i++) {
			current = Math.max(current, max + values[i] - i);
			max = Math.max(max, values[i] + i);	//values[j] + j
		}
		
		return current;
		
	}
	
	public static void main(String[] args) {
		int[] A = {8, 1, 5, 2, 6};
		
		int result = maxScoreSightseeingPair(A);
		
		System.out.println(result);
	}

}
