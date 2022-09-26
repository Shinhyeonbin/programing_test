package programing_test_no1;

import java.util.HashMap;

public class leetcode_no397 {
	private static int re(HashMap<Integer, Integer> map, int n) {
		if(n == 1)
			return 0;
		if(n < 1)
			return Integer.MAX_VALUE;
		if(map.containsKey(n))
			return map.get(n);
		
		int value = 0;
		
		if(n % 2 == 0) {
			value = 1 + re(map, n /2);
		}
		else {
			value = 1 + Math.min(re(map, n+1), re(map, n-1));
		}
		map.put(n, value);
		
		return value;
	}
	
	public static int integerReplacement(int n) {
		HashMap<Integer, Integer> memo = new HashMap<>();
		
		return (int) re(memo, n);
    }
	
	
	public static void main(String[] args) {
		int A = integerReplacement(8);

		System.out.println(A);
	}

}
