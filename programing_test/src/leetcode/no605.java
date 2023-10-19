package leetcode;

/*
 * 꽃을 심는 조건....
 * 
 * 일단 기본적인 조건 -> 자리가0이여야 한다. 앞도 0 뒤도 0 -> 모두 and조건으로 묶는다, 
 *
 * 앞에있는 친구가 0이면 심어야함 -> 문제발생.. 맨앞의 경우 에외가 발생한다. 맨앞 조건을 넣어서 해결
 * 뒤에있는 친구가 0이여야 심을수 있음 -> 맨앞 처럼 문제 가 발생한다. 마지막일 경우 조건을 넣어서 해결한다.
 * 
 * 오류 발생 [0,0,1,0,0] -> count값과 n비교 해결.
 */

public class no605 {
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		if(flowerbed.length == 0) {
			return false;
		}
		int count = 0;
		
		for(int i = 0; i < flowerbed.length; i++) {
			if(flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)){
				flowerbed[i] = 1;
				count++;
			}
		}
		
		if(count >= n) {
			return true;
		}
		
		return false;
		
    }
	public static void main(String[] args) {
		int[] flowerbed = {1,0,0,0,1};
		int n = 1;
		
		System.out.println(canPlaceFlowers(flowerbed, n));
		
	}
}
