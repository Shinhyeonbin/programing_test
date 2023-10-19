package back;


/*
 * 
 * 1차 생각 : 이 문제는 백준의 회의실 배정문제와 비슷하다. 
 * 경우의 수를 생각하면 (2, 3), (2, 4), (2, 5) 같은 경우 1개의 로봇으로 해결가능하다. 
 * 하지만 위의 숫자 다음에 (5, 2)형식으로 들어오게 되면 줄이 다름에도 불구하고 1개의 로봇으로 해결할 수 있다. 같은 열이면 하나의 로봇으로 해결이 가능하다.
 * 
 *  정리하면, 로봇을 같은 열이 동전이 있을 경우 계속해서 오른쪽으로 이동하여 동전을 흡수한다. 같은 열에 동전이 없을 경우 아래로 이동하여 해결한다. 
 * 
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No23248 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int cal = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int coin = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[cal][row];
		
		for(int i = 0; i < coin; i++) {
			st = new StringTokenizer(br.readLine());
			int c_cal = Integer.parseInt(st.nextToken()) - 1;
			int c_row = Integer.parseInt(st.nextToken()) - 1;
			
			map[c_cal][c_row] = 1;
			
		}
		
		for(int i = 0; i < cal; i++) {
			for(int j = 0; j < row; j++) {
				System.out.printf("%d ", map[i][j]);
			}
			System.out.println();
		}
		
		int robot = 0;
		
		while(coin != 0) {
			// 그 줄에 코인이 있는가? 전진해야함... 없으면 return == row라면 다음줄로 
			// coin 열까지 이동해야함 // 2개의 for문으로는 시간소요가 극심 2 point로 변경 
			int d_move = 0;
			
			for(int i = 0; i < row; i++) {
				if(map[d_move][i] == 1) { 	//coin이 존재한다면?
					map[d_move][i] = 0;	//coin 흡수
					coin--;
				}
			}
			d_move++;
			robot++;	//다음로봇 등장 
				
			
		}
		
		System.out.println(robot);
		
	}

}
