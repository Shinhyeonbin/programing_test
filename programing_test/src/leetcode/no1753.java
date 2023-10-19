package leetcode;

/*
 * 처음에는 간단하게 빼면되는 문제인줄 알았으나, 아니였음
 * 생각...
 * 최적의 해는 a + b, b + c, c + a 중 가장 높은값을 찾아서 그 돌을 먼저 제거하는것인줄 알았으나 아니다.
 * 왜 4, 4, 6 상태에서 앞에 2개를 먼저 제거하는가?
 * 
 * 2번쨰 돌과 3번째 돌이 같게 만들면 최적의 해인가?
 * 
 * error case  6, 2, 1 -> 나머지 둘다 0일경우 -> 나머지 2개가 0이면 종료 조건 추가 헤결
 * 
 */

public class no1753 {
	public static int maximumScore(int a, int b, int c) {
        int count = 0;
        
        while(a != 0) {
        	if(b == 0 && c == 0) {
        		break;
        	}
        	
        	if(b > c) {
        		b--;
        	}
        	else {
        		c--;
        	}
        	count++;
        	a--;
        }
        return count + Math.min(b, c);
    }
	public static void main(String[] args) {
		int a = 34;
		int b = 23;
		int c = 42;
		
		System.out.println(maximumScore(a, b, c));
	}
}
