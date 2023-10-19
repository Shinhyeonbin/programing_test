package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2961 {
    static int N;
    static boolean visited[];
    static int min = Integer.MAX_VALUE;
    static int[][] source;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        source = new int[N][2];
        visited = new boolean[N];

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            source[i][0] = Integer.parseInt(st.nextToken());
            source[i][1] = Integer.parseInt(st.nextToken());
        }

        re(0, 1, 0);

        System.out.println(min);


    }

    public static void re(int depth, int mulSour, int sumBitter) {
        if(depth == N - 1 ) {
            int falseCnt = 0;
            for(int i=0;i<N;i++) {
                if(visited[i]) continue;
                falseCnt++;
            }
            if(falseCnt == N) return;
            min = Math.min(min, Math.abs(mulSour - sumBitter));
            return;
        }

        visited[depth] = true;
        re(depth +1,mulSour*source[depth][0],sumBitter+source[depth][1] );
        visited[depth] = false;
        re(depth +1,mulSour,sumBitter);
    }
}
