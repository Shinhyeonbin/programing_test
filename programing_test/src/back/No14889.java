package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
능력치의 최소값을 출력하기 위해서는 두명모두 값이 비등해야한다. -> 값의 차이가 없어야한다.
방문하면

 */

public class No14889 {
    static int[][] arr;
    static int N;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0, 0);

        System.out.println(min);
    }

    private static void backTracking(int idx, int count) {
        if(count == N /2){
            /*
            for(boolean A : visit){
                System.out.printf("%b ", A);
            }
            System.out.println();
            */
            //일단 선수들을 뽑는데에 있어서는 오류가 존재하지 않음

            FindMinValue();
            return;
        }

        for(int i = idx; i < N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                backTracking(i + 1, count + 1);
                visit[i] = false;
            }
        }
    }
    private static void FindMinValue() {
        int team_start = 0;
        int team_link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visit[i] == true && visit[j] == true) {
                    team_start += arr[i][j];
                    team_start += arr[j][i];
                }
                else if (visit[i] == false && visit[j] == false) {
                    team_link += arr[i][j];
                    team_link += arr[j][i];
                }
            }
        }
        int val = Math.abs(team_start - team_link);

        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }

        min = Math.min(val, min);
    }

}