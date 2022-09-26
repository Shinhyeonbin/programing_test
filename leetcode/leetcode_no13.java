package programing_test_no1;

import java.util.*;

public class leetcode_no13 {
	public static void main(String[] args) {
		String s = "MCMXCIV";
		
		if(s == null || s.length() == 0) {
			System.out.println("No input value");
		}
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		int len = s.length();
		int result = map.get(s.charAt(len - 1));
		
		for(int i = len -2; i >= 0; i--) {
			if(map.get(s.charAt(i)) >= map.get(s.charAt(i+1))) {
				result += map.get(s.charAt(i));
			}
			else {
				result -= map.get(s.charAt(i));
			}
		}
		
		System.out.println(result);
		
		
	}
	
	/*
	 * CM은 한 문자로 간주됨
	 * 이문제 해결하는게 핵심 -> if문으로 해결하기에는 어려움
	 * 문제의 힌트 -> hashmap으로 해결
	 * 
	 * 근데 그냥 악으로 조건문 생성해서 하는 사람이 속도의 우위를 보임
	 * 
	 * */

}
