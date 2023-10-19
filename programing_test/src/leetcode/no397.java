package leetcode;


import java.util.HashMap;

public class no397 {
	public static int integerReplacement(int n) {
		HashMap<Long, Integer> memo = new HashMap<>();
		
		return re(memo, n);
    }
    
	//배열로 불가능 -> python 딕션어리 힌트를 얻어 해쉬 맵으로 해결
	//HashMap<Integer, Integer> 인경우 2^31 -1 해결 불가능 -> Long으로 변경
	
   private static int re(HashMap<Long, Integer> map, long n) {
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
	
	public static void main(String[] args) {
		int A = integerReplacement(8);

		System.out.println(A);
	}

}
