package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 
 * 주어진 공식에서 최소의 값을 찾는 문제이다. 
 * 입력은 A, B 두개 입력받는다.
 * 주어진 공식에서 최소의 값 찾는 방안은 B = 8 이면 A = 0인것처럼 주어진 두 값의 차이가 커야 최소의 값이 생성된다.
 * 따라서 각자의 배열을 다르게 정렬하여 문제를 해결할 수 있었다.
 * 
 * int 와 integer의 차이도 학습하자 내림차순 정렬할때, 애먹지 말고 
 * 
 */


public class No1026 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Integer[] A = new Integer[N];
		Integer[] B = new Integer[N];
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		for(int j = 0; j < N; j++) {
			A[j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int j = 0; j < N; j++) {
			B[j] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A); 	//A는 오름차순 
		Arrays.sort(B, Collections.reverseOrder());	//내림차순 정리
		
		int answer = 0;
		
		for(int i = 0; i < N; i++) {
			answer += A[i] * B[i];
		}
		
		System.out.println(answer);
	}
}
