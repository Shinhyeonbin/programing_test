package leetcode;

import java.util.Random;

/*

원의 중심 반경과 위치를 감안할 때, 원 안에 균일한 무작위점을 생성하는 randPoint 함수를 구현하십시오.

솔루션 클래스를 구현하세요:

솔루션(이중 반경, 이중 x_center, 이중 y_center)은 원 반경의 반경과 중심 위치(x_center, y_center)로 물체를 초기화합니다.

randPoint()는 원 안에 임의의 점을 반환합니다. 원의 둘레에 있는 점은 원에 있는 것으로 간주된다. 답은 배열 [x, y]로 반환됩니다.

 */
public class no478 {
    double radius;
    double x_center;
    double y_center;
    Random random;

    public no478(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        this.random = new Random();
    }

    public double[] randPoint() {
        double[] answer = new double[2];
        long x = random.nextLong();
        long y = random.nextLong();
        long x_dis = (long) Math.pow(this.x_center - x, 2);
        long y_dis = (long) Math.pow(this.y_center - y, 2);

        if(Math.sqrt(x_dis + y_dis) <= this.radius){
            answer[0] = x;
            answer[1] = y;
            return answer;
        }
        return randPoint();
    }

    public static void main(String[] args) {

    }
}
