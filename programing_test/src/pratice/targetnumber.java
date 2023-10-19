package pratice;

public class targetnumber {
	static int count = 0;
	
	public static int solution(int[] numbers, int target) {
		
		dfs(numbers, 0, target, 0);
		
		return count;
		
	}
	
	private static void dfs(int[] A, int depth, int target, int sum) {
		if(depth == A.length) {
			if(target == sum) {
				count++;
			}
		}
		else {
			dfs(A, depth + 1, target, sum + A[depth]);
			dfs(A, depth + 1, target, sum - A[depth]);
		}
	}
	
	public static void main(String[] args) {
		int[] A = {4, 1, 2, 1};
		
		int result = solution(A, 4);
		
		System.out.println(result);
	}
}
