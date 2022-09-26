package programing_test_no1;

public class leetcode_no338 {
	
	public static int help(int arr[], int n) {
		if(arr[n/2] != -1) {
			return arr[n/2] +  n % 2;
		}
		else {
			arr[n] = arr[n/2] + n % 2;
			return arr[n];
		}
	}

	public static void countBits(int n) {
		
		int[] arr = new int[n + 1];
		
		for(int i = 0; i < n + 1; i++) {
			arr[i] = -1;
		}
		
		arr[0] = 0;
		arr[1] = 1;
		
		for(int i = 2; i < n + 1; i++) {
			arr[i] = help(arr, i);
		}
		
		for(int i : arr) {
			System.out.println(i);
		}
		
		/*
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			String A = Integer.toBinaryString(i);
			for(int j = 0; j < A.length(); j++) {
				if(A.charAt(j) == '1') {
					count++;		
				}
			}
			arr[i] = count;
			count = 0;
		}
		return arr;
		*/
		
	}
	
	public static void main(String[] args) {
		countBits(1);
		
	}

}
