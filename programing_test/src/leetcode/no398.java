package leetcode;
/*
중복이 가능한 정수 배열 숫자가 주어지면, 주어진 대상 번호의 인덱스를 무작위로 출력한다. 주어진 대상 번호가 배열에 있어야 한다고 가정할 수 있습니다.

솔루션 클래스를 구현하세요:

Solution
(int[] nums) 배열 숫자로 객체를 초기화합니다.
Int pick(int target) nums[i] == target인 nums에서 무작위 인덱스 i를 선택합니다. 유효한 i가 여러 개 있다면, 각 인덱스는 반환할 확률이 같아야 한다.

-> output의 확률이 같아야한다. => 처음짠 코드는 하나의 값만 나오게 호출이 됨 <index 끼리 확률이 다름>

 */

import java.util.ArrayList;
import java.util.Random;

public class no398 {
    int[] arr;
    Random random;


    public no398(int[] nums) {
        this.arr = nums;
        this.random = new Random();
    }

    public int pick(int target) {
        int idx = random.nextInt(arr.length);
        if(arr[idx] == target){
            return idx;
        }
        return pick(target);
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        no398 obj = new no398(A);
        int target = 3;
        int param_1 = obj.pick(target);

        System.out.println(param_1);
    }
}
