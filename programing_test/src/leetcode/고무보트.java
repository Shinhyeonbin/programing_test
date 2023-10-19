package leetcode;

import java.util.Arrays;

/*
 * 일단 최소 비용으로 갈려면 몸무개가 작은 친구들 먼저 태워야한다. -> 그런방식으로 해서 친구들을 탈출시킨다.
 * 
 * 이거 정렬시켜서 -> 100씩 자르면 되지 않나?
 * 되긴하는데 완벽하지 않음 고무보트는 탈출할때 무조건 하나가 필요로 한다. 
 * 
 * 
 * -> 최소값 하나씩 찾아서 태우는 작업 시행
 * -> 반복문 한번으로 실행하여 가능한가 이중반복은 시간 소요가 극심함 
 * -> 첫번째 방법으로 회귀
 * 
 * 
 * 문제점이 뭔지 모르겠음 => 최소끼리의 합만 더해서 생각 이상으로 경우의 수가 많이 나왔을 것으로 예측함 30 50 50 70 인데 2개로 갈수있는걸 3개로 가는꼴  
 * 더해서 limit을 넘지 말해야함 그럴러면 최소의 값과 최대의 값 두개의 포인터로 이동하여 접근하는것 옳은 방법 
 * 
 * 
 * 맨앞에 정렬을 안해서 오류가 남 
 * 
 */


public class 고무보트 {
	public static int solution(int[] people, int limit) {
		int boat = 0;
		
		Arrays.sort(people);
		
		int start = 0;
		int end = people.length - 1;
		
		while(start <= end) {
			boat++;
			if(people[start] + people[end] <= limit) {
				start++;
			}
			end--;
		}
		return boat;
	}
	
	public static void main(String[] args) {
		int[] people = {40, 40, 40, 40, 50};
		int limit = 200;
		
		System.out.println(solution(people, limit));
		
	}
}
/*
\70, 50, 80, 50
# [40, 40, 40, 40, 50], 200 => 3

# [60, 60, 51, 51, 100], 100 => 5

#[40], 40 => 1

#  [40, 55, 55, 60, 60, 60, 70, 80], 100 => 7
*/
