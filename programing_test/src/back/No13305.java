package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No13305 {
    static int[] road;
    static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        road = new int[N- 1];
        cost = new int[N];

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < road.length; i++){
            road[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < cost.length; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int min = cost[0];
        for(int i = 0; i < N - 1; i++){
            if(min > cost[i]){
                min = cost[i];
            }

            sum += (road[i] * min);
        }

        System.out.println(sum);
    }
}
