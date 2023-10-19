package leetcode;

import java.util.Stack;

/*
 * 
 * 괄호 문자열은 다음과 같은 경우에만 유효합니다:

그건 빈 끈이야,

A와 B가 유효한 문자열인 AB(B와 연결된 A)로 쓸 수 있습니다.

그것은 (A)로 쓸 수 있으며, 여기서 A는 유효한 문자열이다.

괄호 문자열 s가 주어집니다. 한 번에 문자열의 어느 위치에나 괄호를 삽입할 수 있습니다.

예를 들어, s = "()))"인 경우, 시작 괄호를 "(()))"로 삽입하거나 닫는 괄호를 "())))로 삽입할 수 있습니다.

S를 유효하게 만드는 데 필요한 최소 이동 수를 반환합니다.

???


 * 그냥 괄호만 닫으면 되는건가?
 * 
 * 저장할 수 있 배열 예를들어  stack하나 만들어서 
 *  하나씩 문자를 보면서 '(' 이면 push ')'면 pop 
 *  그리고 마지막에 stack.size return 
 *  
 *  isEmpty stack Excepotion Error 발생
 *  
 *  ????????????? '(((' test case 3. 제출은 2?????
 *  
 *  => static을 사용해서 error
 *  
 */

public class no921 {
	
	static Stack<Character> stack = new Stack<>();
	
	public static int minAddToMakeValid(String s) {
		int count= 0;
		for(int i = 0; i < s.length(); i++) {
        	char idx = s.charAt(i);
        	
        	if(idx == '(') {
        		stack.push(idx);
        	}
        	else if(idx == ')' && !stack.isEmpty()) {
        		stack.pop();
        	}
        	
        	else if(stack.isEmpty()) {
        		count++;
        	}
        }
        return count + stack.size();
    }
	
	public static void main(String[] args) {
		String problem = "())";
		
		System.out.println(minAddToMakeValid(problem));
	}
}
