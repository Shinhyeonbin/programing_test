package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/*
 * Atm 의 줄을 세우는 문제 => 간단하게 해결 
 * 배열값에서 최소의 값을 가지고가는것이 최선을 보장하는것으로 예측 
 * 따라서 배열을 정렬하고, 값을 더하는 방식으로 해결함
 */


public class No11399 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int people = Integer.parseInt(br.readLine());
		
		int[] time = new int[people];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < people; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time);
		int wait_time = 0;
		int answer = 0;
		
		for(int i = 0; i < people; i++) {
			wait_time += time[i];
			answer += wait_time;
		}
		
		System.out.println(answer);
	}
}
