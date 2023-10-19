package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * 활동 선택 문제 -> 한 사람이 하나의 활동에 대해서만 작업할 수 있는 경우, 최대한 많은 활동을 할 수 있는 수 
 * 풀이 방법은 종료시간을 기준으로 정렬하여 해결한다. 
 * 시작 시간과 끝 시간을이 서로 겹치지 않은 경우의 합이 최대한 많은 활동을 할 수 있는 수이다. 
 */

public class No1931 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int meeting = Integer.parseInt(br.readLine());
		
		int[][] time = new int[meeting][2];
		
		StringTokenizer st;
		
		for(int i = 0; i < meeting; i++) {
			st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());	//start
			time[i][1] = Integer.parseInt(st.nextToken());	//end
		}
		
		// JAVA 2차원 배열 정렬과정 -> 처음보는 과정이니 공부하자
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1])
					return o1[0] - o2[0];
				
				return o1[1] - o2[1];
			}
			
		});
		
		int count = 0;
		int prev_end_time = 0;
		
		for(int i = 0; i < meeting; i++) {
			if(prev_end_time <= time[i][0]) {
				prev_end_time = time[i][1];
				count++;
			}
		}
		
		System.out.println(count);
	}

}
