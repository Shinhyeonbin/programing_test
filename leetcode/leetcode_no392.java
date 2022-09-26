package programing_test_no1;

import java.util.*;

public class leetcode_no392 {
	public static boolean isSubsequence(String s, String t) {
		if(s.length() == 0) {
			return true;
		}
		else {
			if(s.length() > 0 && t.length() == 0)
				return false;
			else {
				if(s.charAt(s.length() - 1) == t.charAt(t.length() - 1)) {
					s = s.substring(0, s.length() - 1);
					t = t.substring(0, t.length() - 1);	
					return isSubsequence(s, t);
				}
				else
					t = t.substring(0, t.length() - 1);
					return isSubsequence(s, t);
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		String s = "axc";
		String t = "ahbgdc";
		
		boolean result = isSubsequence(s, t);
		
		System.out.println(result);
	}
}
