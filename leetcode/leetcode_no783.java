package programing_test_no1;

import java.util.ArrayList;
import java.util.Collections;

public class leetcode_no783{
	
	
	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(3);
		A.add(8);
		A.add(13);
		A.add(5);
		A.add(1);
		A.add(44);
		A.add(64);
		A.add(23);
		A.add(12);
		A.add(16);
		A.add(38);
		A.add(34);
		
		Collections.sort(A);
		
		
		
		System.out.println(A.get(1) - A.get(0));
		
	}
}
