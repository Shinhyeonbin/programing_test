package leetcode;

/*
 * Problem
 * 처음에는 물로 가득 찬 numBottles 물병이 있다. 시장에서 빈 물병을 하나의 전체 물병으로 교환할 수 있습니다.

	물병을 가득 마시는 작업은 그것을 빈 병으로 바꾼다.

	두 정수 numBottles와 numExchange를 감안할 때, 마실 수 있는 최대 물병 수를 반환합니다.
 */


/*
 * 일단 나눠 > 그러고 교환해준값을 numBottles 넣어주면 됨 ==> 이게 탐욕인지 모르겠네 
 * 
 */

public class no1518 {
	public static int numWaterBottles(int numBottles, int numExchange) {
		int count = 0;
        while(numBottles != 0) {
        	numBottles--;	//drinking
        	count++;	//counting 
        	if(count % numExchange == 0) {	//exchanging
        		numBottles++;
        	}
        }
        return count;
    }
	
	public static void main(String[] args) {
		int Bottles = 15;
		int Change = 4;
		
		System.out.println(numWaterBottles(Bottles, Change));
	}
}