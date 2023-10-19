package leetcode;

import java.util.ArrayList;
import java.util.List;

//If you handle List -> very easy solve
//Key point is how to sum before list Element


public class no118 {
	public static List<List<Integer>> generate(int numRows) {
		
		List<List<Integer>> alist = new ArrayList<>();
		
		for(int i = 0; i < numRows; i++) {
			alist.add(new ArrayList<Integer>());
			alist.get(i).add(1);
        }
		
        for(int i = 1; i < numRows; i++) {
			for(int j = 1; j < i ; j++) {
				int left = alist.get(i - 1).get(j);
				int right = alist.get(i - 1).get(j - 1);
				alist.get(i).add(left + right);
			}
            alist.get(i).add(1);
        }
		return alist;
    }
	
	public static void main(String[] args) {
		List<List<Integer>> A = generate(8);
		
	}
}
