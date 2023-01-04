package leetcode;

import java.util.Arrays;
public class no1515 {

    /*
    문제
    배달 회사는 새로운 도시에 새로운 서비스 센터를 짓고 싶어 한다. 이 회사는 2D 맵에서 이 도시의 모든 고객의 위치를 알고 있으며
    모든 고객에게 유클리드 거리의 합이 최소인 위치에 새로운 센터를 건설하기를 원합니다.
    위치[i] = [xi, yi]가 지도에서 고객의 위치인 배열 위치를 감안할 때, 유클리드 거리의 최소 합계를 모든 고객에게 반환합니다.

    #유클리드 거리 = 두점사이의 거리
    즉, 다음 공식을 최소화하도록 서비스 센터 [xcentre, ycentre]의 위치를 선택해야 합니다.

    집들이 모두 원의 가장자리에 있는 것으로 가정, 원의 줌심을 찾는다
    => Error

    처음 앞의 두점씩 연산을 해서 거리의 반을 중심으로 잡는다.
    중삼을 잡은 점을 기준으로 뒤 값을 연산을 해서 중심을 잡는다... -> 틀린 정답..
    => 기존의 예시 {{0,1}, {1,0}, {1,2}, {2,1}} 계산시 4가 아닌 4.155873327143636 오류 발생

    좌표를 정렬하여, 각 좌표의 가장 큰값과 가장 아래에 있는 값의 평균을 중심으로 잡는다.
    [[1,1],[0,0],[2,0]] 에러 발생 Output 2.73607   Expected 2.73205
    중심점 [1, 0.5] 중심점의 연산이 틀렸다고 볼 수는 없음 그렇다고 연산이 틀렸다고 볼 수 없음.... 무언가 놓친 부분이 있다.

     */
    public static double getMinDistSum(int[][] positions) {
        double center_x = 0.0;
        double center_y = 0.0;

        double result = 0.0;

        int size = positions.length;

        int[] x = new int[size];
        int[] y = new int[size];

        for(int i = 0; i <size; i++){
            x[i] = positions[i][0];
            y[i] = positions[i][1];
        }

        Arrays.sort(x);
        Arrays.sort(y);

        center_x = (double) (x[0] + x[size - 1]) / 2;
        center_y = (double) (y[0] + y[size - 1]) / 2;

        System.out.println(y[0]);
        System.out.println(y[size - 1]);

        System.out.println(center_x);
        System.out.println(center_y);

        for(int i = 0; i < positions.length; i++) {
            result += Math.sqrt(Math.pow(center_x - positions[i][0], 2) + Math.pow(center_y - positions[i][1], 2));
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] maps = {{0,1}, {0,0}, {2, 0}};

        double result = getMinDistSum(maps);

        System.out.println(result);

    }
}
