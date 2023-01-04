package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
지원자의 점수를 모두 이중배열로 받는다.
첫번쨰 서류전형의 등수를 기준으로 정렬을 시킨다. => 서류전행의 1등은 무조건 통과하게 된다.
서류전형의 1등의 면접점수를 기준으로 면접등수가 낮은 사람은 통과한다. 통과할 경우에는 통과한 사람이 기준점수가 된다.

처음 문제 이해가 되지 않았지만, 각각 주어지는 값이 등수라고 생각하니 풀 방법이 보였다.
+ 그리디는 이중배열의 정렬도 생각하자
 */

public class No1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int temp = Integer.parseInt(br.readLine());

        for(int i = 0; i < temp; i++){
            int N = Integer.parseInt(br.readLine());
            int pass = 1;
            int set_pass_score;

            int[][] applicant = new int[N][2];

            for(int j = 0; j < N; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                applicant[j][0] = Integer.parseInt(st.nextToken());
                applicant[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(applicant, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]!=o2[0] ? o1[0]-o2[0] : o1[1]-o2[1];
                }
            });

            set_pass_score = applicant[0][1];

            for(int j = 1; j < N; j++){
                if(set_pass_score > applicant[j][1]){
                    set_pass_score = applicant[j][1];
                    pass++;
                }
            }
            System.out.println(pass);
        }

        br.close();

    }
}
