package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 쉬운문제... 
 * 
 */

public class No5585 {
	public static int changer(int money) {
		int change = 1000 - money;
		int count = 0;
		
		int[] coin = {500, 100, 50, 10, 5, 1};
		
		for(int i = 0; i < coin.length; i++) {
			if(change / coin[i] > 0) {
				count += change/coin[i];
				change = change % coin[i];
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		
		br.close();
		
		System.out.println(changer(input));
	}
}
